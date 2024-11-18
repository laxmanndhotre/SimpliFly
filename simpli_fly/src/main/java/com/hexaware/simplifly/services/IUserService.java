package com.hexaware.simplifly.services;

import com.hexaware.simplifly.entities.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {

    User registerUser(User user);

    Optional<User> findByUsername(String username);

    Optional<User> findByEmail(String email);

    Optional<User> getUserById(int id);

    void deleteUser(int id);

    List<User> getAllUsers();

    List<User> getUsersByRole(String role);
}

