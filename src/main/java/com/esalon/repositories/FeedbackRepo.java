package com.esalon.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.esalon.models.Feedback;

@Repository
public interface FeedbackRepo extends JpaRepository<Feedback, Integer>  {
    Feedback findById(int id);
}
