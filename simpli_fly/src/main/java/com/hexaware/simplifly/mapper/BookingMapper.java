package com.hexaware.simplifly.mapper;


import com.hexaware.simplifly.dto.BookingDTO;
import com.hexaware.simplifly.entities.Booking;

public class BookingMapper {

    public static BookingDTO toDTO(Booking booking) {
        BookingDTO bookingDTO = new BookingDTO();
        bookingDTO.setBookingId(booking.getBookingId());
        bookingDTO.setUserId(booking.getUser().getUserId());
        bookingDTO.setRouteId(booking.getRoute().getRouteId());
        bookingDTO.setBookingDate(booking.getBookingDate());
        bookingDTO.setStatus(booking.getStatus().name());
        bookingDTO.setTotalPrice(booking.getTotalPrice());
        bookingDTO.setPaymentStatus(booking.getPaymentStatus().name());
        return bookingDTO;
    }

    public static Booking toEntity(BookingDTO bookingDTO) {
        Booking booking = new Booking();
        booking.setBookingId(bookingDTO.getBookingId());
        // Additional setup for User and Route required
        booking.setBookingDate(bookingDTO.getBookingDate());
        booking.setStatus(Booking.Status.valueOf(bookingDTO.getStatus()));
        booking.setTotalPrice(bookingDTO.getTotalPrice());
        booking.setPaymentStatus(Booking.PaymentStatus.valueOf(bookingDTO.getPaymentStatus()));
        return booking;
    }
}
