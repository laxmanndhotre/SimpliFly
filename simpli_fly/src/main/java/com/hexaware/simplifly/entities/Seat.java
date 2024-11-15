package com.hexaware.simplifly.entities;

import jakarta.persistence.*;


@Entity
@Table(name = "Seats")

public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int seatId;

    @ManyToOne
    @JoinColumn(name = "booking_id", nullable = false)
    private Booking booking;

    @Column(nullable = false, length = 5)
    private String seatNumber;

    @Column(nullable = false)
    private boolean isAvailable = true;

    public int getSeatId() {
        return seatId;
    }

    public void setSeatId(int seatId) {
        this.seatId = seatId;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public Seat(int seatId, Booking booking, String seatNumber, boolean isAvailable) {
        this.seatId = seatId;
        this.booking = booking;
        this.seatNumber = seatNumber;
        this.isAvailable = isAvailable;
    }

    @Override
    public String toString() {
        return "Seat [seatId=" + seatId + ", booking=" + booking + ", seatNumber=" + seatNumber + ", isAvailable="
                + isAvailable + "]";
    }


    
}
