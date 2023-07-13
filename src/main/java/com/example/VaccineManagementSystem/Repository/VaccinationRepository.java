package com.example.VaccineManagementSystem.Repository;

import com.example.VaccineManagementSystem.Models.VaccinationCenter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VaccinationRepository extends JpaRepository<VaccinationCenter, Integer> {

}
