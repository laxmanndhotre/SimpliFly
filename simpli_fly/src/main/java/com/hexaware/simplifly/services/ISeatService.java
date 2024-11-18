package com.hexaware.simplifly.services;

import com.hexaware.simplifly.entities.Seat;


import java.util.List;
import java.util.Optional;

public interface ISeatService {

    public List<Seat> getAvailableSeats(); 

    public Seat updateSeatAvailability(Seat seat) ;

    public Optional<Seat> getSeatById(int id) ;
}
