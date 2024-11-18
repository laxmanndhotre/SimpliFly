package com.hexaware.simplifly.services;

import com.hexaware.simplifly.entities.Seat;

import java.util.List;

public interface ISeatService {

    List<Seat> getSeatsByBookingId(int bookingId);

    List<Seat> getAvailableSeatsByRouteId(int routeId);

    Seat reserveSeat(Seat seat);

    void releaseSeat(int seatId);

    void markSeatAsUnavailable(int seatId);

    Seat addSeat(Seat seat); 

    void deleteSeat(int seatId); 

    Seat updateSeat(int id,Seat seat); 
    
    Seat getSeatById(int seatId);

    List<Seat> getAllSeats(); 
}
