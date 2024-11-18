package com.hexaware.simplifly.services;

import com.hexaware.simplifly.entities.Payment;
import com.hexaware.simplifly.repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IPaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    public Payment processPayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    public List<Payment> getPaymentsByBookingId(int bookingId) {
        return paymentRepository.findByBookingId(bookingId);
    }

    public Optional<Payment> getPaymentById(int id) {
        return paymentRepository.findById(id);
    }
}
