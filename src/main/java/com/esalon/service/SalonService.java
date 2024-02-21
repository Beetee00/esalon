package com.esalon.service;

import com.esalon.auth.responses.RegistrationResponse;
import com.esalon.config.RunTimeExceptionPlaceHolder;
import com.esalon.dto.SalonRequest;
import com.esalon.dto.SalonResponse;
import com.esalon.models.Role;
import com.esalon.models.Salon;
import com.esalon.models.User;
import com.esalon.repositories.SalonRepo;
import com.esalon.service.service_impl.SalonServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
@Service
@RequiredArgsConstructor
public class SalonService implements SalonServiceImpl {

private final SalonRepo salonRepo;

    @Override
    public SalonResponse add(SalonRequest salon) {
        if (salonRepo.existsByName(salon.getName())) {
            throw new RunTimeExceptionPlaceHolder("Salon is already registered!!");
        } else {
            var user = Salon.builder()
                    .name(salon.getName())
                    .address(salon.getAddress())
                    .build();
            user.setCreatedAt(LocalDate.now());
            var savedUser = salonRepo.save(user);
            return SalonResponse.builder()
                    .message("Salon saved successfully")
                    .salon(savedUser)
                    .build();
        }

    }

    @Override
    public List<Salon> getAllCovid() {
        return null;
    }


}
