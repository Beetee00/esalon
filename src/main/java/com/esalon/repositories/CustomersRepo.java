package com.esalon.repositories;

import com.esalon.models.Customers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface CustomersRepo extends JpaRepository<Customers, Integer> {
    Customers findById(int id);
}
