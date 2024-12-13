package com.hexaware.simplifly.controller;

import java.util.List;
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

import com.hexaware.simplifly.entities.Booking;
import com.hexaware.simplifly.exceptions.ResourceNotFoundException;
import com.hexaware.simplifly.services.IBookingService;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    @Autowired
    private IBookingService bookingService;
    @CrossOrigin(origins = "http://localhost:4200") 
    @PostMapping("/new")
    public ResponseEntity<Booking> addBooking(@RequestBody Booking booking) {
        return new ResponseEntity<>(bookingService.createBooking(booking), HttpStatus.CREATED);
    }
    @CrossOrigin(origins = "http://localhost:4200") 
    @GetMapping("/find/id/{id}")
    public ResponseEntity<Booking> getBookingById(@PathVariable int id) throws ResourceNotFoundException {
        Optional<Booking> booking = Optional.ofNullable(bookingService.getBookingById(id));
        return booking.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @CrossOrigin(origins = "http://localhost:4200") 
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Booking>> getBookingsByUserId(@PathVariable int userId) {
        return ResponseEntity.ok(bookingService.getBookingsByUserId(userId));
    }
    @CrossOrigin(origins = "http://localhost:4200") 
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> cancelBooking(@PathVariable int id) throws ResourceNotFoundException {
        try {
			bookingService.cancelBooking(id);
		} catch (ResourceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return ResponseEntity.noContent().build();
    }
}

