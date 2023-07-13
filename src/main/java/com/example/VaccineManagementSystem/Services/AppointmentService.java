package com.example.VaccineManagementSystem.Services;

import com.example.VaccineManagementSystem.Dtos.RequestDtos.AppointmentReqDto;
import com.example.VaccineManagementSystem.Exceptions.DoctorNotFoundException;
import com.example.VaccineManagementSystem.Exceptions.UserNotFoundException;
import com.example.VaccineManagementSystem.Models.Appointment;
import com.example.VaccineManagementSystem.Models.Doctor;
import com.example.VaccineManagementSystem.Models.User;
import com.example.VaccineManagementSystem.Repository.AppointmentRepository;
import com.example.VaccineManagementSystem.Repository.DoctorRepository;
import com.example.VaccineManagementSystem.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    JavaMailSender emailSender;

    public String bookAppointment(AppointmentReqDto appointmentReqDto)throws DoctorNotFoundException, UserNotFoundException {

        Optional<Doctor> doctorOptional = doctorRepository.findById(appointmentReqDto.getDocId()); //null/0
        if(!doctorOptional.isPresent()){
            throw new DoctorNotFoundException("DoctorId not found");
        }
        Optional<User> userOptional = userRepository.findById(appointmentReqDto.getUserId());
        if(!userOptional.isPresent()){
            throw new UserNotFoundException("UserId not found");
        }
        Doctor doctor = doctorOptional.get();
        User user = userOptional.get();

        Appointment appointment = new Appointment();

        //Creating the object and setting of its attributes
        appointment.setAppointmentDate(appointmentReqDto.getAppointmentDate());
        appointment.setAppointmentTime(appointmentReqDto.getAppointmentTime());
        //Setting the foreign key attributes
        appointment.setDoctor(doctor);
        appointment.setUser(user);

        //Saving it before so that I can get the PK of the appointment table...
        appointment = appointmentRepository.save(appointment);

        doctor.getAppointmentList().add(appointment);
        user.getAppointmentList().add(appointment);

        doctorRepository.save(doctor);
        userRepository.save(user);

//        //Send an email to the sender

        String body = "Hi "+user.getName()+"!"+"\n" +
                "You have successfully booked an appointment on "+appointment.getAppointmentDate() + ", at "+appointment.getAppointmentTime()+"."+ "\n"+
                "Your doctor is "+doctor.getName()+ "."+ "\n"+
                "Please reach at "+doctor.getVaccinationCenter().getAddress()+"."+"\n"
                + "Mask is mandatory" +".";




        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("yeduruswapnareddy@gmail.com");
        message.setTo(appointment.getUser().getEmailId());
        message.setSubject("Your Vaccination is booked successfully!!");
        message.setText(body);
        emailSender.send(message);

//        String enteredString;
//
//        if(enteredString.equals(Gender.FEMALE)|| enteredString.equals(Gender.MALE))
            return "Appointment booked successfully";

    }

}