package com.hexaware.simplifly.services;


import com.hexaware.simplifly.entities.Flight;
import com.hexaware.simplifly.repositories.FlightRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IFlightService {

    public static final FlightRepository flightRepository = null;

    public Flight addFlight(Flight flight);

    public List<Flight> getFlightsByOwnerId(int ownerId);

    public Flight getFlightById(int id);

    public void deleteFlight(int id);

	public List<Flight> getAllFlights();

	public Flight updateFlight(int id, Flight flight);
}
