package com.example.VaccineManagementSystem.Models;

import com.example.VaccineManagementSystem.Enums.Gender;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Table(name = "users")
@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    private String name;
    private int age;
    @Column(unique = true)
    private String emailId;
    private String mobileNo;
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @JsonIgnore
    @OneToOne(mappedBy="user",cascade = CascadeType.ALL)
    private Dose dose;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Appointment> appointmentList= new ArrayList<>();

}
