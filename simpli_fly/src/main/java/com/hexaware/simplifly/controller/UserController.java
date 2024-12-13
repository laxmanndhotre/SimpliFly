package com.hexaware.simplifly.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.simplifly.entities.User;
import com.hexaware.simplifly.services.IUserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private IUserService userService;
    @CrossOrigin(origins = "http://localhost:4200") 
    @PostMapping("/add")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        return new ResponseEntity<>(userService.registerUser(user), HttpStatus.CREATED);
    }
    @CrossOrigin(origins = "http://localhost:4200") 
    @GetMapping("/find/{id}")
    public ResponseEntity<User> getUserById(@PathVariable int id) {
        Optional<User> user = userService.getUserById(id);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @CrossOrigin(origins = "http://localhost:4200") 
    @GetMapping("/username/{username}")
    public ResponseEntity<User> getUserByUsername(@PathVariable String username) {
        Optional<User> user = userService.findByUsername(username);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @CrossOrigin(origins = "http://localhost:4200") 
    @GetMapping("/email/{email}")
    public ResponseEntity<User> getUserByEmail(@PathVariable String email) {
        Optional<User> user = userService.findByEmail(email);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @CrossOrigin(origins = "http://localhost:4200") 
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}

