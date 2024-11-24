package com.hexaware.simplifly.services;

import com.hexaware.simplifly.entities.Booking;
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
    public Optional<Booking> getBookingById(int bookingId) {
        return bookingRepository.findById(bookingId);
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
public void cancelBooking(int bookingId) {
    Optional<Booking> existingBooking = bookingRepository.findById(bookingId);
    if (existingBooking.isPresent()) {
        Booking booking = existingBooking.get();
        if (booking.getStatus().equalsIgnoreCase("canceled")) {
            throw new IllegalStateException("Booking is already canceled");
        }
        booking.setStatus("canceled");
        bookingRepository.save(booking);
    } else {
        throw new IllegalArgumentException("Booking with id " + bookingId + " does not exist");
    }
}


}

