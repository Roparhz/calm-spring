package com.project.calm.repositories;

import com.project.calm.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findById(Integer id);
    boolean existsByEmailContainingIgnoreCase(String email);
    Optional<User> findByEmail(String email);

}
