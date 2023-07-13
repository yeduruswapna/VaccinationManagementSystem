package com.example.VaccineManagementSystem.Services;


import com.example.VaccineManagementSystem.Models.Dose;
import com.example.VaccineManagementSystem.Models.User;
import com.example.VaccineManagementSystem.Repository.DoseRepository;
import com.example.VaccineManagementSystem.Repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoseService {
    @Autowired
    DoseRepository doseRepository;

    @Autowired
    UserRepository userRepository;


    public String giveDose(String doseId, Integer userId) {
        User user = userRepository.findById(userId).get();
        Dose dose= new Dose();
        dose.setDoseId(doseId);
        dose.setUser(user);
        user.setDose(dose);
        userRepository.save(user);
        return "Dose Given To User Successfully";
    }
}























