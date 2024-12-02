package com.hexaware.simplifly;

import com.hexaware.simplifly.entities.Booking;
import com.hexaware.simplifly.entities.Seat;
import com.hexaware.simplifly.repositories.SeatRepository;
import com.hexaware.simplifly.services.SeatServiceImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class SeatServiceImplTest {

    @Mock
    private SeatRepository seatRepository;

    @InjectMocks
    private SeatServiceImpl seatService;

    private Seat seat;
    private Booking booking;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        booking = new Booking(); // Create a mock or an actual Booking object as needed
        seat = new Seat(1, booking, "A1", true);
    }

    @Test
    void testGetSeatsByBookingId() {
        List<Seat> seats = Arrays.asList(seat, new Seat(2, booking, "B2", true));
        when(seatRepository.findByBookingBookingId(1)).thenReturn(seats);

        List<Seat> foundSeats = seatService.getSeatsByBookingId(1);
        assertEquals(2, foundSeats.size());
        verify(seatRepository, times(1)).findByBookingBookingId(1);
    }

    @Test
    void testGetAvailableSeatsByRouteId() {
        List<Seat> seats = Arrays.asList(seat, new Seat(2, booking, "B2", true));
        when(seatRepository.findAvailableSeatsByRouteId(1)).thenReturn(seats);

        List<Seat> foundSeats = seatService.getAvailableSeatsByRouteId(1);
        assertEquals(2, foundSeats.size());
        verify(seatRepository, times(1)).findAvailableSeatsByRouteId(1);
    }

    @Test
    void testReserveSeat() {
        seat.setAvailable(false);
        when(seatRepository.save(any(Seat.class))).thenReturn(seat);

        Seat reservedSeat = seatService.reserveSeat(seat);
        assertNotNull(reservedSeat);
        assertFalse(reservedSeat.isAvailable());
        verify(seatRepository, times(1)).save(seat);
    }

    @Test
    void testReleaseSeat() {
        when(seatRepository.findById(1)).thenReturn(Optional.of(seat));

        seatService.releaseSeat(1);
        seat.setAvailable(true); // Marking the seat as available
        assertTrue(seat.isAvailable());
        verify(seatRepository, times(1)).save(seat);
    }

    @Test
    void testMarkSeatAsUnavailable() {
        when(seatRepository.findById(1)).thenReturn(Optional.of(seat));

        seatService.markSeatAsUnavailable(1);
        seat.setAvailable(false); // Marking the seat as unavailable
        assertFalse(seat.isAvailable());
        verify(seatRepository, times(1)).save(seat);
    }

    @Test
    void testAddSeat() {
        when(seatRepository.save(any(Seat.class))).thenReturn(seat);

        Seat createdSeat = seatService.addSeat(seat);
        assertNotNull(createdSeat);
        assertEquals("A1", createdSeat.getSeatNumber());
        verify(seatRepository, times(1)).save(seat);
    }

    @Test
    void testDeleteSeat() {
        when(seatRepository.existsById(1)).thenReturn(true);

        seatService.deleteSeat(1);
        verify(seatRepository, times(1)).deleteById(1);
    }

    @Test
    void testUpdateSeat() {
        when(seatRepository.existsById(1)).thenReturn(true);
        when(seatRepository.save(any(Seat.class))).thenReturn(new Seat(1, booking, "B2", true));

        Seat updatedSeat = new Seat(1, booking, "B2", true);
        Seat result = seatService.updateSeat(1, updatedSeat);

        assertNotNull(result);
        assertEquals("B2", result.getSeatNumber());
        verify(seatRepository, times(1)).existsById(1);
        verify(seatRepository, times(1)).save(updatedSeat);
    }

    @Test
    void testGetSeatById() {
        when(seatRepository.findById(1)).thenReturn(Optional.of(seat));

        Seat foundSeat = seatService.getSeatById(1);
        assertNotNull(foundSeat);
        assertEquals(1, foundSeat.getSeatId());
        verify(seatRepository, times(1)).findById(1);
    }
}
