package com.example.VaccineManagementSystem.Models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Table(name= "Vaccination_center")
@Entity
@Data
public class VaccinationCenter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String centerName;
    private LocalTime openingTime;
    private LocalTime closingTime;
    private String address;
    private int doseCapacity;

    @JsonIgnore
    @OneToMany(mappedBy = "vaccinationCenter", cascade = CascadeType.ALL)
    private List<Doctor> doctorList= new ArrayList<>();
}
