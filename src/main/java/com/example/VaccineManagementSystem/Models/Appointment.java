package com.example.VaccineManagementSystem.Models;

import jakarta.persistence.*;
import lombok.Data;


import java.time.LocalTime;
import java.util.Date;


@Table(name="appointments")
@Entity
@Data

public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Date appointmentDate;
    private LocalTime appointmentTime;

    @ManyToOne
    @JoinColumn
    private Doctor doctor;

    @ManyToOne
    @JoinColumn
    private User user;

}
