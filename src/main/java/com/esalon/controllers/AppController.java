package com.esalon.controllers;

import com.esalon.config.RunTimeExceptionPlaceHolder;
import com.esalon.dto.AppointmentDTO;
import com.esalon.dto.AppointmentMapper;
import com.esalon.models.*;
import com.esalon.repositories.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/esalon/apps")
public class AppController {
    private final AppointmentRepo appointmentRepo;
    private final CustomersRepo customersRepo;
    private final UserRepository userRepository;
    private final SalonRepo salonRepo;
    private final StockRepo stockRepo;
    @GetMapping("/all/{customerId}")
    public List<AppointmentMapper> getAllAppointments(@PathVariable(value = "customerId") int customerId) {
        System.out.println(appointmentRepo.findAppointmentsByCustomerId(customerId));
        return appointmentRepo.findAppointmentsByCustomerId(customerId);
    }
    @GetMapping("/all")
    public List<Appointment> getAllApps() {
        return appointmentRepo.findAll();
    }
    @PostMapping("/{customerId}/{userId}/{salonId}")
    public Appointment add(@PathVariable("customerId") int customerId, @PathVariable("userId") int userId,
            @PathVariable("salonId") int salonId, @RequestBody AppointmentDTO test) {
        Customers sl = customersRepo.findById(customerId);
        User user = userRepository.findById(userId);
        Salon sa = salonRepo.findSalonById(salonId);
        if (sl == null || user == null || sa == null) {
            throw new RunTimeExceptionPlaceHolder(
                    "Make sure you load data for Customer, Salon and Barber/Hairdresser first");
        } else {
            Appointment g = Appointment.builder()
                    .name(test.getName())
                    .phone(test.getPhone())
                    .address(test.getAddress())
                    .time(test.getTime())
                    .style(test.getStyle())
                    .build();
            g.setUser(user);
            g.setCustomer(sl);
            g.setSalon(sa);
            g.setStatus("Appointment Pending");
            return appointmentRepo.save(g);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Appointment> updateTutorial(@PathVariable("id") Integer id, @RequestBody AppointmentDTO tutorial) {
        ///Optional<Optional<Tracking>> tutorialData = Optional.of(trackingRepository.findById(id));
        Appointment t = appointmentRepo.findAppointmentById(id);
        t.setStatus("Confirmed");
        return new ResponseEntity<>(appointmentRepo.save(t), HttpStatus.OK);
    }
}
