package com.hexaware.simplifly;


import com.hexaware.simplifly.entities.Flight;
import com.hexaware.simplifly.repositories.FlightRepository;
import com.hexaware.simplifly.services.FlightServiceImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class FlightServiceImplTest {

    @InjectMocks
    private FlightServiceImpl flightService;

    @Mock
    private FlightRepository flightRepository;

    private Flight flight;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        flight = new Flight();
        flight.setFlightId(1);
        flight.setFlightName("Air India");
    }

    @Test
    public void testGetFlightById_Success() {
        when(flightRepository.findById(1)).thenReturn(Optional.of(flight));

        Flight foundFlight = flightService.getFlightById(1);

        assertNotNull(foundFlight);
        assertEquals(1, foundFlight.getFlightId());
    }

    

    @Test
    public void testAddFlight_Success() {
        when(flightRepository.save(flight)).thenReturn(flight);

        Flight savedFlight = flightService.addFlight(flight);

        assertNotNull(savedFlight);
        assertEquals("Air India", savedFlight.getFlightName());
    }
}
