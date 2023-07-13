package com.example.VaccineManagementSystem.Services;

import com.example.VaccineManagementSystem.Dtos.RequestDtos.AssociateDocDto;
import com.example.VaccineManagementSystem.Exceptions.CenterNotFoundException;
import com.example.VaccineManagementSystem.Exceptions.DoctorAlreadyExistsException;
import com.example.VaccineManagementSystem.Exceptions.DoctorNotFoundException;
import com.example.VaccineManagementSystem.Exceptions.EmailIdEmptyException;
import com.example.VaccineManagementSystem.Models.Doctor;
import com.example.VaccineManagementSystem.Models.VaccinationCenter;
import com.example.VaccineManagementSystem.Repository.DoctorRepository;
import com.example.VaccineManagementSystem.Repository.VaccinationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    VaccinationRepository vaccinationRepository;
    public String addDoctor(Doctor doctor) throws DoctorAlreadyExistsException, EmailIdEmptyException {
        if(doctor.getEmailId()==null)
            throw new EmailIdEmptyException("EmailId Is Mandatory");
        if(doctorRepository.findByEmailId(doctor.getEmailId())!=null)
            throw new DoctorAlreadyExistsException("Doctor With This EmailId Already Exists");

        doctorRepository.save(doctor);
        return "Doctor Has Been Added SuccessFully";
    }

    public String associateDoctor(AssociateDocDto associateDocDto) throws DoctorNotFoundException, ClassCastException {
        Integer docId= associateDocDto.getDocId();
        Optional<Doctor>doctorOptional= doctorRepository.findById(docId);
        if(!doctorOptional.isPresent())
            throw new DoctorNotFoundException("Doctor Id is Incorrect");

        Integer centerId= associateDocDto.getCenterId();
        Optional<VaccinationCenter>centerOptional= vaccinationRepository.findById(centerId);
        if(!centerOptional.isPresent())
            throw new CenterNotFoundException("Center Id is Incorrect");

        Doctor doctor=doctorOptional.get();
        VaccinationCenter vaccinationCenter= centerOptional.get();

        doctor.setVaccinationCenter(vaccinationCenter);
        vaccinationCenter.getDoctorList().add(doctor);

        vaccinationRepository.save(vaccinationCenter);
        return "Doctor Has Been Associated To center";


    }
}



















