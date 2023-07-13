package com.example.VaccineManagementSystem.Exceptions;

public class EmailIdEmptyException extends RuntimeException{
    public EmailIdEmptyException(String message){
        super(message);
    }
}
