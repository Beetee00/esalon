package com.esalon.controllers;
import java.util.List;
import java.util.ArrayList;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.esalon.config.RunTimeExceptionPlaceHolder;
import com.esalon.dto.AppointmentDTO;
import com.esalon.dto.AppointmentMapper;
import com.esalon.dto.FeedbackDTO;
import com.esalon.models.Appointment;
import com.esalon.models.Customers;
import com.esalon.models.Feedback;
import com.esalon.models.Salon;
import com.esalon.models.User;
import com.esalon.repositories.CustomersRepo;
import com.esalon.repositories.FeedbackRepo;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/esalon/feedback")
public class FeedbackController {
   final private FeedbackRepo feedbackRepo;
   private final CustomersRepo customersRepo;
    @GetMapping("/all")
    public List<FeedbackDTO> getAllComments() {
        Iterable<Feedback> all = feedbackRepo.findAll();
        List<FeedbackDTO> allTests = new ArrayList<>();
        all.iterator().forEachRemaining(t -> {
            FeedbackDTO testDTO = FeedbackDTO.builder()
                    .comment(t.getComment())
                    .suggestion(t.getSuggestion())
                   
                    .build();
            allTests.add(testDTO);
        });
        return allTests;
    }

    @PostMapping("/{customerId}/")
    public Feedback add(@PathVariable("customerId") int customerId, @RequestBody FeedbackDTO test) {

        Customers sl = customersRepo.findById(customerId);
    
        if (sl == null) {
            throw new RunTimeExceptionPlaceHolder(
                    "You are not allowed to comment if you are not a customer");
        } else {
            Feedback g = Feedback.builder()
                    .comment(test.getComment())
                    .suggestion(test.getSuggestion())
                    .customer(sl)
                    .build();
            g.setCustomer(sl);
            System.out.println("Added");
            return feedbackRepo.save(g);
        }

    }

}
