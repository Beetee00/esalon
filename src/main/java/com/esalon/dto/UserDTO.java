package com.esalon.dto;

import com.esalon.models.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private String id;
    private String name;
    private String surname;
    private String email;
    private String address;
    private String phone;
    private String password;
    private Role role;
}
