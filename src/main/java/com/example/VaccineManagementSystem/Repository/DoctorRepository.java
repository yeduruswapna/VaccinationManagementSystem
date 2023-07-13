package com.example.VaccineManagementSystem.Repository;

import com.example.VaccineManagementSystem.Models.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
    public Doctor findByEmailId(String emailId);

}
