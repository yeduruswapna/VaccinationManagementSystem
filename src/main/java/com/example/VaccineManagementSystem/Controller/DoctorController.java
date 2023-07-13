package com.example.VaccineManagementSystem.Controller;

import com.example.VaccineManagementSystem.Dtos.RequestDtos.AssociateDocDto;
import com.example.VaccineManagementSystem.Models.Doctor;
import com.example.VaccineManagementSystem.Services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    @PostMapping("/add")
    public String addDoctor(@RequestBody Doctor doctor){
        try{
            String str= doctorService.addDoctor(doctor);
            return str;
        }catch(Exception e){
            return e.getMessage();
        }
    }

    @PostMapping("/associateDoctorWithCenter")
    public ResponseEntity<String> associateDoctor(@RequestBody AssociateDocDto associateDocDto){
        try{
            String str= doctorService.associateDoctor(associateDocDto);
            return new ResponseEntity<>(str, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

}
