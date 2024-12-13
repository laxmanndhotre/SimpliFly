package com.hexaware.simplifly.controller;


import com.hexaware.simplifly.entities.Flight;
import com.hexaware.simplifly.services.IFlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/flights")
public class FlightController {

    @Autowired
    private IFlightService flightService;
    @CrossOrigin(origins = "http://localhost:4200") 
    @GetMapping("/getall")
    public ResponseEntity<List<Flight>> getAllFlights() {
        List<Flight> flights = flightService.getAllFlights();
        return new ResponseEntity<>(flights, HttpStatus.OK);
    }
    @CrossOrigin(origins = "http://localhost:4200") 
    @GetMapping("/get/{id}")
    public ResponseEntity<Flight> getFlightById(@PathVariable int id) {
        Flight flight = flightService.getFlightById(id);
        return new ResponseEntity<>(flight, HttpStatus.OK);
    }
    @CrossOrigin(origins = "http://localhost:4200") 
    @PostMapping("/add")
    public ResponseEntity<Flight> addFlight(@RequestBody Flight flight) {
        Flight newFlight = flightService.addFlight(flight);
        return new ResponseEntity<>(newFlight, HttpStatus.CREATED);
    }
    @CrossOrigin(origins = "http://localhost:4200") 
    @PutMapping("/update/{id}")
    public ResponseEntity<Flight> updateFlight(@PathVariable int id, @RequestBody Flight flight) {
        Flight updatedFlight = flightService.updateFlight(id, flight);
        return new ResponseEntity<>(updatedFlight, HttpStatus.OK);
    }
    @CrossOrigin(origins = "http://localhost:4200") 
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteFlight(@PathVariable int id) {
        flightService.deleteFlight(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

