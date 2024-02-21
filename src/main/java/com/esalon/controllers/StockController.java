package com.esalon.controllers;

import com.esalon.config.RunTimeExceptionPlaceHolder;
import com.esalon.dto.StockDTO;
import com.esalon.exceptions.UserAlreadyExistsException;
import com.esalon.models.Salon;
import com.esalon.models.Stock;
import com.esalon.repositories.SalonRepo;
import com.esalon.repositories.StockRepo;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/esalon/stock")
public class StockController {

    private final StockRepo vaccinationStockRepo;
    private final SalonRepo salonRepo;

    @PostMapping("/add/{id}")
    public Stock add(@PathVariable("id") int id, @RequestBody StockDTO test) {
        Salon sl = salonRepo.findSalonById(id);
        boolean sal = salonRepo.existsById(id);
        if (sal) {
            if (vaccinationStockRepo.existsByName(test.getName())) {
                throw new UserAlreadyExistsException("" + test.getName() + " already exists");
            } else {
                Stock g = Stock.builder()
                        .name(test.getName())
                        .units(test.getUnits())
                        .type(test.getType())
                        .build();
                System.out.println("Added ");
                var s = vaccinationStockRepo.save(g);

                return s;
            }
        } else {
            throw new RunTimeExceptionPlaceHolder("Salon not found");
        }

    }

    @GetMapping("/all")
    public List<StockDTO> getAllChecks() {
        Iterable<Stock> all = vaccinationStockRepo.findAll();
        List<StockDTO> allTests = new ArrayList<>();
        all.iterator().forEachRemaining(t -> {
            StockDTO testDTO = StockDTO.builder()
                    .name(t.getName())
                    .units(t.getUnits())
                    .type(t.getType())
                    .build();
            allTests.add(testDTO);
        });

        return allTests;
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Stock> updateTutorial(@PathVariable("id") Integer id, @RequestBody StockDTO tutorial) {



        Stock t = vaccinationStockRepo.findStockById(id);
        if(t == null){
            throw new RunTimeExceptionPlaceHolder("Stock with that Id is not found");
        } else{
            t.setName(tutorial.getName());
            t.setType(tutorial.getType());
            t.setUnits(tutorial.getUnits());

            return new ResponseEntity<>(vaccinationStockRepo.save(t), HttpStatus.OK);
        }

    }
}
