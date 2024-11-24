package com.hexaware.simplifly.controller;

import com.hexaware.simplifly.entities.Flight;
import com.hexaware.simplifly.entities.Route;
import com.hexaware.simplifly.entities.Seat;
import com.hexaware.simplifly.entities.Payment;
import com.hexaware.simplifly.services.IAdminActionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminActionsController {

    @Autowired
    private IAdminActionsService adminActionsService;

    
    @GetMapping("/flights")
    public ResponseEntity<List<Flight>> getAllFlights() {
        List<Flight> flights = adminActionsService.getAllFlights();
        return new ResponseEntity<>(flights, HttpStatus.OK);
    }

    @GetMapping("/flights/{id}")
    public ResponseEntity<Flight> getFlightById(@PathVariable int id) {
        Flight flight = adminActionsService.getFlightById(id);
        return new ResponseEntity<>(flight, HttpStatus.OK);
    }

    @PostMapping("/flights/add")
    public ResponseEntity<Flight> addFlight(@RequestBody Flight flight) {
        Flight newFlight = adminActionsService.addFlight(flight);
        return new ResponseEntity<>(newFlight, HttpStatus.CREATED);
    }

    @PutMapping("/flights/update{id}")
    public ResponseEntity<Flight> updateFlight(@PathVariable int id, @RequestBody Flight flight) {
        Flight updatedFlight = adminActionsService.updateFlight(id, flight);
        return new ResponseEntity<>(updatedFlight, HttpStatus.OK);
    }

    @DeleteMapping("/flights/remove/{id}")
    public ResponseEntity<Void> deleteFlight(@PathVariable int id) {
        adminActionsService.deleteFlight(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
    @GetMapping("/routes")
    public ResponseEntity<List<Route>> getAllRoutes() {
        List<Route> routes = adminActionsService.getAllRoutes();
        return new ResponseEntity<>(routes, HttpStatus.OK);
    }

    @GetMapping("/routes/get/{id}")
    public ResponseEntity<Route> getRouteById(@PathVariable int id) {
        Route route = adminActionsService.getRouteById(id);
        return new ResponseEntity<>(route, HttpStatus.OK);
    }

    @PostMapping("/routes/add")
    public ResponseEntity<Route> addRoute(@RequestBody Route route) {
        Route newRoute = adminActionsService.addRoute(route);
        return new ResponseEntity<>(newRoute, HttpStatus.CREATED);
    }

    @PutMapping("/routes/update/{id}")
    public ResponseEntity<Route> updateRoute(@PathVariable int id, @RequestBody Route route) {
        Route updatedRoute = adminActionsService.updateRoute(id, route);
        return new ResponseEntity<>(updatedRoute, HttpStatus.OK);
    }

    @DeleteMapping("/routes/{id}")
    public ResponseEntity<Void> deleteRoute(@PathVariable int id) {
        adminActionsService.deleteRoute(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/seats")
    public ResponseEntity<List<Seat>> getAllSeats() {
        List<Seat> seats = adminActionsService.getAllSeats();
        return new ResponseEntity<>(seats, HttpStatus.OK);
    }

    @GetMapping("/seats/{id}")
    public ResponseEntity<Seat> getSeatById(@PathVariable int id) {
        Seat seat = adminActionsService.getSeatById(id);
        return new ResponseEntity<>(seat, HttpStatus.OK);
    }

    @PostMapping("/seats/add")
    public ResponseEntity<Seat> addSeat(@RequestBody Seat seat) {
        Seat newSeat = adminActionsService.addSeat(seat);
        return new ResponseEntity<>(newSeat, HttpStatus.CREATED);
    }

    @PutMapping("/seats/update{id}")
    public ResponseEntity<Seat> updateSeat(@PathVariable int id, @RequestBody Seat seat) {
        Seat updatedSeat = adminActionsService.updateSeat(id, seat);
        return new ResponseEntity<>(updatedSeat, HttpStatus.OK);
    }

    @DeleteMapping("/seats/delete/{id}")
    public ResponseEntity<Void> deleteSeat(@PathVariable int id) {
        adminActionsService.deleteSeat(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Payment endpoints
    @GetMapping("/payments")
    public ResponseEntity<List<Payment>> getAllPayments() {
        List<Payment> payments = adminActionsService.getAllPayments();
        return new ResponseEntity<>(payments, HttpStatus.OK);
    }

    @GetMapping("/payments/{id}")
    public ResponseEntity<Payment> getPaymentById(@PathVariable int id) {
        Payment payment = adminActionsService.getPaymentById(id);
        return new ResponseEntity<>(payment, HttpStatus.OK);
    }

    @PostMapping("/payments/add")
    public ResponseEntity<Payment> addPayment(@RequestBody Payment payment) {
        Payment newPayment = adminActionsService.addPayment(payment);
        return new ResponseEntity<>(newPayment, HttpStatus.CREATED);
    }

    @PutMapping("/payments/update/{id}")
    public ResponseEntity<Payment> updatePayment(@PathVariable int id, @RequestBody Payment payment) {
        Payment updatedPayment = adminActionsService.updatePayment(id, payment);
        return new ResponseEntity<>(updatedPayment, HttpStatus.OK);
    }

    @DeleteMapping("/payments/delete/{id}")
    public ResponseEntity<Void> deletePayment(@PathVariable int id) {
        adminActionsService.deletePayment(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
