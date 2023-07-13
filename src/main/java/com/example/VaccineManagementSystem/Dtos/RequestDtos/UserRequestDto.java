package com.example.VaccineManagementSystem.Dtos.RequestDtos;

import com.example.VaccineManagementSystem.Enums.Gender;
import lombok.Data;

@Data
public class UserRequestDto {
    private String name;
    private int age;
    private String emailId;
    private String mobileNo;
    private Gender gender;
}
