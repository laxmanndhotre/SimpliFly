package com.hexaware.simplifly.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "Payments")

public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int paymentId;

    @ManyToOne
    @JoinColumn(name = "booking_id", nullable = false)
    private Booking booking;

    @Column(nullable = false)
    private double amount;

    @Column(nullable = false)
    private LocalDateTime paymentDate = LocalDateTime.now();

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PaymentMethod paymentMethod;

//    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    public enum PaymentMethod {
    	credit_card, debit_card, paypal, upi;

        
    }

    public enum Status {
    	successful, failed, refunded, pending
    }

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDateTime getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDateTime paymentDate) {
        this.paymentDate = paymentDate;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status2) {
        this.status = status2;
    }

    public Payment(int paymentId, Booking booking, double amount, LocalDateTime paymentDate,
            PaymentMethod paymentMethod, Status status) {
        this.paymentId = paymentId;
        this.booking = booking;
        this.amount = amount;
        this.paymentDate = paymentDate;
        this.paymentMethod = paymentMethod;
        this.status = status;
    }

    public Payment() {
		// TODO Auto-generated constructor stub
	}

	@Override
    public String toString() {
        return "Payment [paymentId=" + paymentId + ", booking=" + booking + ", amount=" + amount + ", paymentDate="
                + paymentDate + ", paymentMethod=" + paymentMethod + ", status=" + status + "]";
    }

    
}
