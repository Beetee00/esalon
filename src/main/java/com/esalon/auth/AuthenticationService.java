package com.esalon.auth;


import com.esalon.auth.request.AuthenticationRequest;
import com.esalon.auth.request.RegisterRequest;
import com.esalon.auth.responses.AuthenticationResponse;
import com.esalon.auth.responses.RegistrationResponse;
import com.esalon.config.RunTimeExceptionPlaceHolder;
import com.esalon.models.Role;
import com.esalon.models.User;
import com.esalon.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository repository;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    public RegistrationResponse register(RegisterRequest request) throws RunTimeExceptionPlaceHolder {

        if (repository.existsByEmail(request.getEmail())) {
            throw new RunTimeExceptionPlaceHolder("Username is already taken!!");
        } else {
            var user = User.builder()
                    .name(request.getName())
                    .surname(request.getSurname())
                    .email(request.getEmail())
                    .address(request.getAddress())
                    .phone(request.getPhone())
                    .password(passwordEncoder.encode(request.getPassword()))
                    .role(Role.valueOf(request.getRole().name()))
                    .build();
            user.setCreatedAt(LocalDate.now());
            var savedUser = repository.save(user);
            return RegistrationResponse.builder()
                    .message("User Account created successfully!!")
                    .email(savedUser.getEmail())
                    .build();
        }
    }
    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                ));
        var user = repository.findByEmail(request.getEmail())
                .orElseThrow();
                    return AuthenticationResponse.builder()
                    .message("Account verified")
                    .user(user)
                    .build();
    }
}





