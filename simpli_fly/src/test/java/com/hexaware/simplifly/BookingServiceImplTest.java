package com.hexaware.simplifly;


import com.hexaware.simplifly.entities.Booking;
import com.hexaware.simplifly.exceptions.ResourceNotFoundException;
import com.hexaware.simplifly.repositories.BookingRepository;
import com.hexaware.simplifly.services.BookingServiceImpl;

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
public class BookingServiceImplTest {

    @InjectMocks
    private BookingServiceImpl bookingService;

    @Mock
    private BookingRepository bookingRepository;

    private Booking booking;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        booking = new Booking();
        booking.setBookingId(1);
        booking.setStatus(Booking.Status.CONFIRMED);
    }

    @Test
    public void testGetBookingById_Success() throws ResourceNotFoundException {
        when(bookingRepository.findById(1)).thenReturn(Optional.of(booking));

        Optional<Booking> foundBooking = Optional.of(bookingService.getBookingById(1));

        assertTrue(foundBooking.isPresent());
        assertEquals(1, foundBooking.get().getBookingId());
    }

    @Test
    public void testGetBookingById_NotFound() {
        when(bookingRepository.findById(1)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> {
            bookingService.getBookingById(1);
        });
    }

    @Test
    public void testCancelBooking_Success() throws ResourceNotFoundException {
        when(bookingRepository.findById(1)).thenReturn(Optional.of(booking));

        bookingService.cancelBooking(1);

        verify(bookingRepository, times(1)).save(booking);
        assertEquals(Booking.Status.CANCELED, booking.getStatus());
    }

    @Test
    public void testCancelBooking_AlreadyCanceled() {
        booking.setStatus(Booking.Status.CANCELED);
        when(bookingRepository.findById(1)).thenReturn(Optional.of(booking));

        assertThrows(IllegalStateException.class, () -> {
            bookingService.cancelBooking(1);
        });
    }
}
