package com.hexaware.simplifly.services;

import com.hexaware.simplifly.entities.Booking;
import com.hexaware.simplifly.exceptions.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;

public interface IBookingService {

    Booking createBooking(Booking booking);

    List<Booking> getBookingsByUserId(int userId);

    Optional<Booking> getBookingById(int bookingId) throws ResourceNotFoundException;

    void cancelBooking(int bookingId) throws ResourceNotFoundException;

    List<Booking> getBookingsByRouteId(int routeId);

    List<Booking> getAllBookings();
}

