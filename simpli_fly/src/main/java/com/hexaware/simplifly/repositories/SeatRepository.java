package com.hexaware.simplifly.repositories;


import com.hexaware.simplifly.entities.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SeatRepository extends JpaRepository<Seat, Integer> {
    List<Seat> findByBookingBookingId(int bookingId);
    List<Seat> findByIsAvailable(boolean isAvailable);
    @Query("SELECT s FROM Seat s WHERE s.booking.route.routeId = :routeId AND s.isAvailable = true")
    List<Seat> findAvailableSeatsByRouteId(@Param("routeId") int routeId);
}

