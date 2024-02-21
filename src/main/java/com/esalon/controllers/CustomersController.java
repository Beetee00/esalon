
package com.esalon.controllers;

import com.esalon.dto.CustomersDTO;
import com.esalon.dto.SalonRequest;
import com.esalon.models.Customers;
import com.esalon.models.Salon;
import com.esalon.repositories.CustomersRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/esalon/customers")
public class CustomersController {

    private final CustomersRepo customersRepo;
    @PostMapping("/save")
    public Customers add(@RequestBody CustomersDTO test) {

        Customers g = Customers.builder()
                .name(test.getName())
                .address(test.getAddress())
                .email(test.getEmail())
                .phone(test.getPhone())
                .build();

        customersRepo.save(g);
        return g;
    }


    @GetMapping("/all")
    public List<Customers> getAllCustomers() {
        Iterable<Customers> all = customersRepo.findAll();
        List<Customers> allTests = new ArrayList<>();
        all.iterator().forEachRemaining(t -> {
            Customers testDTO = Customers.builder()
                    .id(t.getId())
                    .name(t.getName())
                    .address(t.getAddress())
                    .phone(t.getPhone())
                    .email(t.getEmail())
                    .appointments(t.getAppointments())
                    .build();
            allTests.add(testDTO);
        });
        return allTests;
    }
}
