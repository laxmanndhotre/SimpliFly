package com.hexaware.simplifly.services;

import com.hexaware.simplifly.entities.Seat;
import com.hexaware.simplifly.repositories.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SeatServiceImpl implements ISeatService {

    @Autowired
    private SeatRepository seatRepository;

    @Override
    public List<Seat> getSeatsByBookingId(int bookingId) {
        return seatRepository.findByBookingBookingId(bookingId);
    }

    @Override
    public List<Seat> getAvailableSeatsByRouteId(int routeId) {
        return seatRepository.findAvailableSeatsByRouteId(routeId);
    }

    @Override
    public Seat reserveSeat(Seat seat) {
        if (seat == null || seat.getSeatNumber() == null) {
            throw new IllegalArgumentException("Seat or Seat Number cannot be null");
        }
        seat.setAvailable(false); // Mark the seat as reserved
        return seatRepository.save(seat);
    }

    @Override
    public void releaseSeat(int seatId) {
        Optional<Seat> seatOptional = seatRepository.findById(seatId);
        if (seatOptional.isEmpty()) {
            throw new IllegalArgumentException("Seat with ID " + seatId + " does not exist");
        }
        Seat seat = seatOptional.get();
        seat.setAvailable(true); // Mark the seat as available
        seatRepository.save(seat);
    }

    @Override
    public void markSeatAsUnavailable(int seatId) {
        Optional<Seat> seatOptional = seatRepository.findById(seatId);
        if (seatOptional.isEmpty()) {
            throw new IllegalArgumentException("Seat with ID " + seatId + " does not exist");
        }
        Seat seat = seatOptional.get();
        seat.setAvailable(false); 
        seatRepository.save(seat);
    }

    @Override
    public Seat addSeat(Seat seat) {
        if (seat == null || seat.getSeatNumber() == null) {
            throw new IllegalArgumentException("Invalid seat details provided");
        }
        return seatRepository.save(seat);
    }

    @Override
    public void deleteSeat(int seatId) {
        if (!seatRepository.existsById(seatId)) {
            throw new IllegalArgumentException("Seat with ID " + seatId + " does not exist");
        }
        seatRepository.deleteById(seatId);
    }

    @Override
    public Seat updateSeat(int id,Seat seat) {
        if (seat == null ) {
            throw new IllegalArgumentException("Invalid seat details provided");
        }
        if (!seatRepository.existsById(seat.getSeatId())) {
            throw new IllegalArgumentException("Seat with ID " + seat.getSeatId() + " does not exist");
        }
        return seatRepository.save(seat);
    }

    @Override
    public Seat getSeatById(int seatId) {
        return seatRepository.findById(seatId)
                .orElseThrow(() -> new IllegalArgumentException("Seat with ID " + seatId + " not found"));
    }

    @Override
    public List<Seat> getAllSeats() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllSeats'");
    }
}
