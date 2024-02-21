package com.esalon.service.service_impl;

import com.esalon.dto.UserDTO;
import com.esalon.models.User;

import java.util.List;

public interface UserServiceImpl {
    User add(User user);
    List<UserDTO> getAllUsers();
    void delete(String email);
    User getUser(String email);
    User update(User user);
}
