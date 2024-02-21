package com.esalon.controllers;

import com.esalon.config.RunTimeExceptionPlaceHolder;
import com.esalon.dto.SalonRequest;
import com.esalon.models.Salon;
import com.esalon.repositories.SalonRepo;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/esalon/salon")
public class SalonController {

private final SalonRepo salonRepo;
    @PostMapping("/save")
    public Salon add(@RequestBody SalonRequest test) {
        
            Salon g = Salon.builder()
                    .name(test.getName())
                    .address(test.getAddress())
                    .build();
                  
                    salonRepo.save(g);
            return g;
        }
       
    
    @GetMapping("/all")
    public List<Salon> getAllChecks() {
        Iterable<Salon> all = salonRepo.findAll();
        List<Salon> allTests = new ArrayList<>();
        all.iterator().forEachRemaining(t -> {
            Salon testDTO = Salon.builder()
            .id(t.getId())
                    .name(t.getName())
                   .address(t.getAddress())
                   .stock(t.getStock())
                    .build();
            allTests.add(testDTO);
        });
        return allTests;
    }
}
