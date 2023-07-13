package com.example.VaccineManagementSystem.Services;

import com.example.VaccineManagementSystem.Exceptions.VaccinationAddressNotFoundException;
import com.example.VaccineManagementSystem.Models.VaccinationCenter;
import com.example.VaccineManagementSystem.Repository.VaccinationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VaccinationService {
    @Autowired
    VaccinationRepository vaccinationRepository;

    public String addCenter(VaccinationCenter vaccinationCenter)throws VaccinationAddressNotFoundException {
        if(vaccinationCenter.getAddress()==null)
            throw new VaccinationAddressNotFoundException("Vaccination Address Is Empty");

        vaccinationRepository.save(vaccinationCenter);

        return "VaccinationCenter Added At Location " + vaccinationCenter.getAddress();
    }
}
