package com.example.VaccineManagementSystem.Services;

import com.example.VaccineManagementSystem.Dtos.RequestDtos.UpdateEmailDto;
import com.example.VaccineManagementSystem.Models.User;
import com.example.VaccineManagementSystem.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User addUser(User user){
        userRepository.save(user);
        return user;
    }


    public Date getVaccinationDate(Integer userId) {
        User user= userRepository.findById(userId).get();
        return user.getDose().getVaccinationDate();
    }

    public String updateEmail(UpdateEmailDto updateEmailDto) {
        int userid= updateEmailDto.getUserId();
        User user= userRepository.findById(userid).get();
        user.setEmailId(updateEmailDto.getNewEmailId());
        userRepository.save(user);
        return " Old Email Has Been Modified With New One " + updateEmailDto.getNewEmailId();

    }

    public User getUserByEmail(String email) {
        User user= userRepository.findByEmailId(email);
        return user;
    }
}


















