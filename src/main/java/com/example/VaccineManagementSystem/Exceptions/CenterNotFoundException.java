package com.example.VaccineManagementSystem.Exceptions;

public class CenterNotFoundException extends RuntimeException{
    public CenterNotFoundException(String message){
        super(message);
    }
}
