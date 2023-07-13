package com.example.VaccineManagementSystem.Controller;

import com.example.VaccineManagementSystem.Dtos.RequestDtos.UpdateEmailDto;
import com.example.VaccineManagementSystem.Models.User;
import com.example.VaccineManagementSystem.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping("/add")
    public User addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @GetMapping("/getVaccinationDate")
    public Date getVaccinationDate(@RequestParam("userId") Integer userId){
        return userService.getVaccinationDate(userId);
    }

    @PutMapping("/updateEmail")
    public String updateEmail(@RequestBody UpdateEmailDto updateEmailDto){
        return userService.updateEmail(updateEmailDto);
    }

    @GetMapping("/getByEmail/{emailId}")
    public User getUserByEmail(@PathVariable("emailId") String email){
        return userService.getUserByEmail(email);
    }
}
