package com.hexaware.simplifly.repositories;

import com.hexaware.simplifly.entities.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface SeatRepository extends JpaRepository<Seat, Integer> {
    List<Seat> findByBookingId(int bookingId);
    List<Seat> findByIsAvailable(boolean isAvailable);
    Seat save(Optional<Seat> existingSeat);
    List<Seat> findAvailableSeatsByRouteId(int routeId);
}
