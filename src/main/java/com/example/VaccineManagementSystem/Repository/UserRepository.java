package com.example.VaccineManagementSystem.Repository;

import com.example.VaccineManagementSystem.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer>{
    User findByEmailId(String emailId);

}
