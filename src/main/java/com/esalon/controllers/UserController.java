package com.esalon.controllers;

import com.esalon.models.Salon;
import com.esalon.models.User;
import com.esalon.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/esalon/users")
public class UserController {
    private final UserRepository userRepository;
    @GetMapping("/all")
    public List<User> getAllChecks() {
        Iterable<User> all = userRepository.findAll();
        List<User> allTests = new ArrayList<>();
        all.iterator().forEachRemaining(t -> {
            User testDTO = User.builder()
                    .id(t.getId())
                    .name(t.getName())
                    .surname(t.getSurname())
                    .address(t.getAddress())
                    .phone(t.getPhone())
                    .role(t.getRole())
                    .email(t.getEmail())
                    .appointments(t.getAppointments())
                    .build();
            allTests.add(testDTO);
        });
        return allTests;
    }


}
