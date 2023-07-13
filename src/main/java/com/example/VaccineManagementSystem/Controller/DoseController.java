package com.example.VaccineManagementSystem.Controller;

import com.example.VaccineManagementSystem.Services.DoseService;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dose")
@Data
public class DoseController {
    @Autowired
    DoseService doseService;
    @PostMapping("/giveDose")
    public String giveDose(@RequestParam("doseId") String doseId, @RequestParam("userId") Integer userId){
        return doseService.giveDose(doseId, userId);
    }
}
