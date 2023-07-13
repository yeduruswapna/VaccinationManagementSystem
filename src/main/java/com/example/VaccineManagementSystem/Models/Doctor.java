package com.example.VaccineManagementSystem.Models;

import com.example.VaccineManagementSystem.Enums.Gender;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Table(name= "doctors")
@Entity
@Data
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int docId;
    private String name;
    private int age;
    @Column(unique = true)
    private String emailId;
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @JsonIgnore
    @ManyToOne
    @JoinColumn
    private VaccinationCenter vaccinationCenter;

    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL)
    private List<Appointment> appointmentList= new ArrayList<>();

}
