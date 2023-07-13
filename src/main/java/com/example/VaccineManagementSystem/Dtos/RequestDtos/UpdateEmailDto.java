package com.example.VaccineManagementSystem.Dtos.RequestDtos;

import lombok.Data;

@Data
public class UpdateEmailDto {
    private int userId;
    private String newEmailId;
}
