package com.hexaware.simplifly.mapper;


import com.hexaware.simplifly.dto.FlightDTO;
import com.hexaware.simplifly.entities.Flight;

public class FlightMapper {

    public static FlightDTO toDTO(Flight flight) {
        FlightDTO flightDTO = new FlightDTO();
        flightDTO.setFlightId(flight.getFlightId());
        flightDTO.setFlightName(flight.getFlightName());
        flightDTO.setFlightNumber(flight.getFlightNumber());
        flightDTO.setOwnerId(flight.getOwnerId());
        flightDTO.setTotalSeats(flight.getTotalSeats());
        flightDTO.setBaggageLimit(flight.getBaggageLimit());
        return flightDTO;
    }

    public static Flight toEntity(FlightDTO flightDTO) {
        Flight flight = new Flight();
        flight.setFlightId(flightDTO.getFlightId());
        flight.setFlightName(flightDTO.getFlightName());
        flight.setFlightNumber(flightDTO.getFlightNumber());
        flight.setOwnerId(flightDTO.getOwnerId());
        flight.setTotalSeats(flightDTO.getTotalSeats());
        flight.setBaggageLimit(flightDTO.getBaggageLimit());
        return flight;
    }
}
