package com.esalon.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import com.fasterxml.jackson.annotation.JsonBackReference;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "appointment")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String address;
    private String phone;
    private String time;
    private String style;
    private String status;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customers customer;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "salon_id")
    private Salon salon;
}
