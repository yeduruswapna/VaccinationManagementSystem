package com.example.VaccineManagementSystem.Controller;


import com.example.VaccineManagementSystem.Dtos.RequestDtos.AppointmentReqDto;
import com.example.VaccineManagementSystem.Services.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {


    @Autowired
    AppointmentService appointmentService;

    @PostMapping("/bookAppointment")
    public ResponseEntity<String> bookAppointment(@RequestBody AppointmentReqDto appointmentReqDto){
        try{
            String str= appointmentService.bookAppointment(appointmentReqDto);
            return new ResponseEntity<>(str, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
