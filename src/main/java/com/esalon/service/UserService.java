package com.esalon.service;

import com.esalon.dto.UserDTO;
import com.esalon.exceptions.UserAlreadyExistsException;
import com.esalon.models.Role;
import com.esalon.models.User;
import com.esalon.repositories.UserRepository;
import com.esalon.service.service_impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService implements UserServiceImpl {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    @Override
    public User add(User user) {

        if (userRepository.existsByEmail(user.getEmail())){
            throw new UserAlreadyExistsException("A user with " +user.getEmail() +" already exists");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setCreatedAt(LocalDate.now());
        user.setCreatedBy("Admin");
        return userRepository.save(user);
    }

    @Override
    public List<UserDTO> getAllUsers() {

        Iterable<User> all = userRepository.findAll();
        List<UserDTO> allUsers = new ArrayList<>();
        all.iterator().forEachRemaining(u->{
            UserDTO userResponse = UserDTO.builder()
                    .id(u.getId().toString())
                    .name(u.getName())
                    .surname(u.getSurname())
                    .email(u.getEmail())
                    .role(Role.valueOf(u.getRole().name()))
                    .address(u.getAddress())
                    .phone(u.getPhone())
                    .build();
            allUsers.add(userResponse);
        });

        return allUsers;

    }

    @Override
    public void delete(String email) {

    }

    @Override
    public User getUser(String email) {
        return null;
    }

    @Override
    public User update(User user) {
        return null;
    }
}
