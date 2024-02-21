package com.esalon.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customers")
public class Customers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String phone;
    private String email;
    private String address;

    @JsonManagedReference
    @OneToMany(mappedBy = "customer")
    private List<Appointment> appointments;

    @JsonManagedReference
    @OneToMany(mappedBy = "customer")
    private List<Feedback> feedbackList;
}
