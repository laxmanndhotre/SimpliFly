package com.hexaware.simplifly.services;

import com.hexaware.simplifly.entities.Booking;
import com.hexaware.simplifly.exceptions.ResourceNotFoundException;
import com.hexaware.simplifly.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingServiceImpl implements IBookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Override
    public Booking createBooking(Booking booking) {
        if (booking == null || booking.getUserId() == 0 || booking.getRouteId() == 0) {
            throw new IllegalArgumentException("Booking details cannot be null or incomplete");
        }
        if (booking.getTotalPrice() <= 0) {
            throw new IllegalArgumentException("Total price must be greater than zero");
        }
        return bookingRepository.save(booking);
    }

    @Override
    public Booking getBookingById(int bookingId) throws ResourceNotFoundException {
        return bookingRepository.findById(bookingId)
                .orElseThrow(() -> new ResourceNotFoundException("Booking not found with ID: " + bookingId));
    }

    @Override
    public List<Booking> getBookingsByUserId(int userId) {
        return bookingRepository.findByUserUserId(userId);
    }

    @Override
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    @Override
    public List<Booking> getBookingsByRouteId(int routeId) {
        return bookingRepository.findByRouteRouteId(routeId);
    }

    @Override
    public void cancelBooking(int bookingId) throws ResourceNotFoundException {
        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new ResourceNotFoundException("Booking not found with ID: " + bookingId));
        
        if (booking.getStatus() == Booking.Status.CANCELED) {
            throw new IllegalStateException("Booking is already canceled");
        }
        booking.setStatus("canceled");
        bookingRepository.save(booking);
    }
}
