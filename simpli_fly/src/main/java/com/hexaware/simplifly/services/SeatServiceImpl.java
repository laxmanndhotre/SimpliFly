package com.hexaware.simplifly.services;

import com.hexaware.simplifly.entities.Seat;
//import com.hexaware.simplifly.exceptions.ResourceNotFoundException;
import com.hexaware.simplifly.repositories.SeatRepository;
import com.hexaware.simplifly.services.ISeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SeatServiceImpl implements ISeatService {

    @Autowired
    private SeatRepository seatRepository;

    @Override
    public List<Seat> getAvailableSeats() {
        return seatRepository.findByIsAvailable(true);
    }

    @Override
    public Seat updateSeatAvailability(Seat seat) {
        Optional<Seat> existingSeat = seatRepository.findById(seat.getSeatId());
        // if (existingSeat.isEmpty()) {
        //     throw new ResourceNotFoundException("Seat not found with ID: " + seat.getSeatId());
        // }
        return seatRepository.save(existingSeat);
    }

    @Override
    public Optional<Seat> getSeatById(int id) {
        return seatRepository.findById(id);
                // .or(() -> {
                //     throw new ResourceNotFoundException("Seat not found with ID: " + id);
                // });
    }
}
