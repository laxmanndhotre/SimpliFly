package com.hexaware.simplifly.mapper;


import com.hexaware.simplifly.dto.PaymentDTO;
import com.hexaware.simplifly.entities.Payment;

public class PaymentMapper {

    public static PaymentDTO toDTO(Payment payment) {
        PaymentDTO paymentDTO = new PaymentDTO();
        paymentDTO.setPaymentId(payment.getPaymentId());
        paymentDTO.setBookingId(payment.getBooking().getBookingId());
        paymentDTO.setAmount(payment.getAmount());
        paymentDTO.setPaymentDate(payment.getPaymentDate());
        paymentDTO.setPaymentMethod(payment.getPaymentMethod().name());
        paymentDTO.setStatus(payment.getStatus().name());
        return paymentDTO;
    }

    public static Payment toEntity(PaymentDTO paymentDTO) {
        Payment payment = new Payment();
        payment.setPaymentId(paymentDTO.getPaymentId());
        // Additional setup for Booking required
        payment.setAmount(paymentDTO.getAmount());
        payment.setPaymentDate(paymentDTO.getPaymentDate());
        payment.setPaymentMethod(Payment.PaymentMethod.valueOf(paymentDTO.getPaymentMethod()));
        payment.setStatus(Payment.Status.valueOf(paymentDTO.getStatus()));
        return payment;
    }
}
