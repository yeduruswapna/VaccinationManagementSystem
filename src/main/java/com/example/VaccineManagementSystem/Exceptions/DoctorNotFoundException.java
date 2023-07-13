package com.example.VaccineManagementSystem.Exceptions;

public class DoctorNotFoundException extends RuntimeException{
    public DoctorNotFoundException(String message){
        super(message);
    }
}
