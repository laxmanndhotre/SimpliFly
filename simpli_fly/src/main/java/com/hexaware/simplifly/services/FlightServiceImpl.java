package com.hexaware.simplifly.services;


import com.hexaware.simplifly.entities.Flight;
import com.hexaware.simplifly.exceptions.ResourceNotFoundException;
import com.hexaware.simplifly.repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class FlightServiceImpl implements IFlightService {

    @Autowired
    private FlightRepository flightRepository;

    @Override
    public Flight addFlight(Flight flight) {
        return flightRepository.save(flight);
    }

    @Override
    public List<Flight> getFlightsByOwnerId(int ownerId) {
        return flightRepository.findByOwnerId(ownerId);
    }

    @Override
    public Flight getFlightById(int id) {
        try {
			return flightRepository.findById(id)
			        .orElseThrow(() -> new ResourceNotFoundException("Flight not found with ID: " + id));
		} catch (ResourceNotFoundException e) {
			e.printStackTrace();
		}
		return null;
    }


    @Override
    public void deleteFlight(int id) {
    	try {
        if (!flightRepository.existsById(id)) {
            throw new ResourceNotFoundException("Flight not found with ID: " + id);
        }
    	}
    	catch(ResourceNotFoundException e) {
			e.printStackTrace();
    	}
        flightRepository.deleteById(id);
    }

	@Override
	public List<Flight> getAllFlights() {
		return flightRepository.findAll();
	}

	@Override
    public Flight updateFlight(int id, Flight flight) {
        try {
		Flight existingFlight = flightRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Flight not found with ID: " + id));
		
        existingFlight.setFlightName(flight.getFlightName());
        existingFlight.setFlightNumber(flight.getFlightNumber());
        existingFlight.setOwnerId(flight.getOwnerId());
        existingFlight.setTotalSeats(flight.getTotalSeats());
        existingFlight.setBaggageLimit(flight.getBaggageLimit());
        existingFlight.setUpdatedAt(LocalDateTime.now());
        return flightRepository.save(existingFlight);
        }
		catch(ResourceNotFoundException e) {
			e.printStackTrace();
		}
		return null;
    }

}

