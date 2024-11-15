package com.hexaware.simplifly.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hexaware.simplifly.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);
}

