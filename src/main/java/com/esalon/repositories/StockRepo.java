package com.esalon.repositories;

import com.esalon.models.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepo extends JpaRepository<Stock, Integer> {
    boolean existsByName(String name);

    Stock findByName(String name);

    Stock findStockById(Integer id);
}
