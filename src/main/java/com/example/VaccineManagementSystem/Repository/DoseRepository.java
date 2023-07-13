package com.example.VaccineManagementSystem.Repository;

import com.example.VaccineManagementSystem.Models.Dose;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoseRepository extends JpaRepository<Dose, Integer> {
}
