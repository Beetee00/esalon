package com.esalon.repositories;

import com.esalon.models.Salon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalonRepo extends JpaRepository<Salon, Integer> {
    boolean existsByName(String name);
    boolean existsById(int id);

    Salon findSalonById(int id);
}
