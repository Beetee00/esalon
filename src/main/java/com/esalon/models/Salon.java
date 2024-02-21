package com.esalon.models;

import com.esalon.utils.DateAudit;
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
@Table(name = "salon")
public class Salon extends DateAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String address;
    @JsonManagedReference
    //@OneToMany(mappedBy="salon")
    @OneToMany(mappedBy="salon", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Stock> stock;

    @JsonManagedReference
    @OneToMany(mappedBy = "salon")
    private List<Appointment> appointments;

}
