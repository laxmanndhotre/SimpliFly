package com.hexaware.simplifly.services;

import com.hexaware.simplifly.entities.Payment;

import java.util.List;

public interface IPaymentService {

    Payment addPayment(Payment payment);

    List<Payment> getAllPayments();

    Payment getPaymentById(int id);

    void deletePayment(int id);

    Payment updatePayment(int id, Payment payment);

    Payment processPayment(Payment payment);

    List<Payment> getPaymentsByBookingId(int bookingId);
}
