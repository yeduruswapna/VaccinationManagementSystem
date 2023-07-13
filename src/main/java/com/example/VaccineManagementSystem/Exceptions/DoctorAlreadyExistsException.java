package com.example.VaccineManagementSystem.Exceptions;

public class DoctorAlreadyExistsException extends RuntimeException{
    public DoctorAlreadyExistsException(String message){
        super(message);
    }
}
