package com.hexaware.simplifly.controller;

import com.hexaware.simplifly.entities.Seat;
import com.hexaware.simplifly.services.ISeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/seats")
public class SeatController {

    @Autowired
    private ISeatService seatService;
    @CrossOrigin(origins = "http://localhost:4200") 
    @GetMapping("/booking/{bookingId}")
    public ResponseEntity<List<Seat>> getSeatsByBookingId(@PathVariable int bookingId) {
        List<Seat> seats = seatService.getSeatsByBookingId(bookingId);
        return ResponseEntity.ok(seats);
    }
    @CrossOrigin(origins = "http://localhost:4200") 
    @GetMapping("/route/{routeId}/available")
    public ResponseEntity<List<Seat>> getAvailableSeatsByRouteId(@PathVariable int routeId) {
        List<Seat> availableSeats = seatService.getAvailableSeatsByRouteId(routeId);
        return ResponseEntity.ok(availableSeats);
    }
    @CrossOrigin(origins = "http://localhost:4200") 
    @PostMapping("/reserve")
    public ResponseEntity<Seat> reserveSeat(@RequestBody Seat seat) {
        Seat reservedSeat = seatService.reserveSeat(seat);
        return ResponseEntity.ok(reservedSeat);
    }
    @CrossOrigin(origins = "http://localhost:4200") 
    @PutMapping("/release/{seatId}")
    public ResponseEntity<Void> releaseSeat(@PathVariable int seatId) {
        seatService.releaseSeat(seatId);
        return ResponseEntity.noContent().build();
    }
    @CrossOrigin(origins = "http://localhost:4200") 
    @PutMapping("/mark-unavailable/{seatId}")
    public ResponseEntity<Void> markSeatAsUnavailable(@PathVariable int seatId) {
        seatService.markSeatAsUnavailable(seatId);
        return ResponseEntity.noContent().build();
    }
    @CrossOrigin(origins = "http://localhost:4200") 
    @GetMapping("/{seatId}")
    public ResponseEntity<Seat> getSeatById(@PathVariable int seatId) {
        Seat seat = seatService.getSeatById(seatId);
        return ResponseEntity.ok(seat);
    }
    @CrossOrigin(origins = "http://localhost:4200") 
    @PostMapping
    public ResponseEntity<Seat> addSeat(@RequestBody Seat seat) {
        Seat newSeat = seatService.addSeat(seat);
        return ResponseEntity.ok(newSeat);
    }
    @CrossOrigin(origins = "http://localhost:4200") 
    @PutMapping("/{seatId}")
    public ResponseEntity<Seat> updateSeat(@PathVariable int seatId, @RequestBody Seat seat) {
        Seat updatedSeat = seatService.updateSeat(seatId, seat);
        return ResponseEntity.ok(updatedSeat);
    }
    @CrossOrigin(origins = "http://localhost:4200") 
    @DeleteMapping("/{seatId}")
    public ResponseEntity<Void> deleteSeat(@PathVariable int seatId) {
        seatService.deleteSeat(seatId);
        return ResponseEntity.noContent().build();
    }
}
