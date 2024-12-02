package com.hexaware.simplifly.mapper;


import com.hexaware.simplifly.dto.SeatDTO;
import com.hexaware.simplifly.entities.Seat;

public class SeatMapper {

    public static SeatDTO toDTO(Seat seat) {
        SeatDTO seatDTO = new SeatDTO();
        seatDTO.setSeatId(seat.getSeatId());
        seatDTO.setBookingId(seat.getBooking().getBookingId());
        seatDTO.setSeatNumber(seat.getSeatNumber());
        seatDTO.setAvailable(seat.isAvailable());
        return seatDTO;
    }

    public static Seat toEntity(SeatDTO seatDTO) {
        Seat seat = new Seat();
        seat.setSeatId(seatDTO.getSeatId());
        // Additional setup for Booking required
        seat.setSeatNumber(seatDTO.getSeatNumber());
        seat.setAvailable(seatDTO.isAvailable());
        return seat;
    }
}
