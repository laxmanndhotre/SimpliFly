package com.hexaware.simplifly.services;

import com.hexaware.simplifly.entities.Payment;
import com.hexaware.simplifly.repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentServiceImpl implements IPaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public Payment addPayment(Payment payment) {
        validatePayment(payment);
        return paymentRepository.save(payment);
    }

    @Override
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    @Override
    public Payment getPaymentById(int id) {
        return paymentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Payment with ID " + id + " not found"));
    }

    @Override
    public void deletePayment(int id) {
        if (!paymentRepository.existsById(id)) {
            throw new IllegalArgumentException("Payment with ID " + id + " does not exist");
        }
        paymentRepository.deleteById(id);
    }

    @Override
    public Payment updatePayment(int id, Payment payment) {
        if (!paymentRepository.existsById(id)) {
            throw new IllegalArgumentException("Payment with ID " + id + " does not exist");
        }
        validatePayment(payment);
        payment.setPaymentId(id); 
        return paymentRepository.save(payment);
    }

    @Override
    public Payment processPayment(Payment payment) {
        validatePayment(payment);
        payment.setStatus("successful"); 		
        return paymentRepository.save(payment);
    }

    @Override
    public List<Payment> getPaymentsByBookingId(int bookingId) {
        if (bookingId <= 0) {
            throw new IllegalArgumentException("Booking ID must be greater than zero");
        }
        return paymentRepository.findByBookingBookingId(bookingId);
    }

    /**
     * Utility method to validate payment details
     */
    private void validatePayment(Payment payment) {
        if (payment == null) {
            throw new IllegalArgumentException("Payment cannot be null");
        }
        if (payment.getAmount() <= 0) {
            throw new IllegalArgumentException("Payment amount must be greater than zero");
        }
        if (payment.getPaymentMethod() == null ) {
            throw new IllegalArgumentException("Payment method cannot be null or empty");
        }
        if (payment.getStatus() == null) {
            throw new IllegalArgumentException("Payment status cannot be null or empty");
        }
    }

	
}
