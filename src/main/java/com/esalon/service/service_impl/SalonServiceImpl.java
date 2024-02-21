package com.esalon.service.service_impl;

import com.esalon.dto.SalonRequest;
import com.esalon.dto.SalonResponse;
import com.esalon.models.Salon;

import java.util.List;

public interface SalonServiceImpl {

    SalonResponse add(SalonRequest salon);

    List<Salon> getAllCovid();
}
