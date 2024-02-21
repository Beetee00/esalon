package com.esalon.repositories;

import com.esalon.dto.AppointmentMapper;
import com.esalon.models.Appointment;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepo extends JpaRepository<Appointment, Integer> {

    //List<Appointment> findAppointmentsByUserId(int id);

     @Query(value="SELECT u.name, u.phone, u.address FROM appointment u WHERE u.user_id = ?1",nativeQuery = true)
     List<AppointmentMapper> findAppointmentsByUserId(int id);

     @Query(value="SELECT u.name, u.phone, u.address FROM appointment u WHERE u.customer_id = ?1",nativeQuery = true)
     List<AppointmentMapper> findAppointmentsByCustomerId(int id);

     Appointment findAppointmentById(int id);
}
