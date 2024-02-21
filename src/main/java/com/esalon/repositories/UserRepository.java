package com.esalon.repositories;

import com.esalon.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    //User findByEmail(String email);
    Optional<User> findByEmail(String email);
    boolean existsByEmail(String email);

    User findById(int id);

}
