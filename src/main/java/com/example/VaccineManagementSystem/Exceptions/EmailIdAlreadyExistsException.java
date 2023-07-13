package com.example.VaccineManagementSystem.Exceptions;

public class EmailIdAlreadyExistsException extends RuntimeException{
    public EmailIdAlreadyExistsException(String message){
        super(message);
    }
}
