package com.hexaware.simplifly;

import com.hexaware.simplifly.entities.Booking;
import com.hexaware.simplifly.entities.Payment;
import com.hexaware.simplifly.repositories.PaymentRepository;
import com.hexaware.simplifly.services.PaymentServiceImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PaymentServiceImplTest {

    @Mock
    private PaymentRepository paymentRepository;

    @InjectMocks
    private PaymentServiceImpl paymentService;

    private Payment payment;
    private Booking booking;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        booking = new Booking(); // Create a mock or an actual Booking object as needed
        payment = new Payment(1, booking, 1000.0, LocalDateTime.now(), Payment.PaymentMethod.credit_card, Payment.Status.pending);
    }

    @Test
    void testAddPayment() {
        when(paymentRepository.save(any(Payment.class))).thenReturn(payment);

        Payment createdPayment = paymentService.addPayment(payment);
        assertNotNull(createdPayment);
        assertEquals(1000.0, createdPayment.getAmount());
        verify(paymentRepository, times(1)).save(payment);
    }

    @Test
    void testGetAllPayments() {
        List<Payment> payments = Arrays.asList(payment, new Payment(2, booking, 500.0, LocalDateTime.now(), Payment.PaymentMethod.debit_card, Payment.Status.successful));
        when(paymentRepository.findAll()).thenReturn(payments);

        List<Payment> foundPayments = paymentService.getAllPayments();
        assertEquals(2, foundPayments.size());
        verify(paymentRepository, times(1)).findAll();
    }

    @Test
    void testGetPaymentById() {
        when(paymentRepository.findById(1)).thenReturn(Optional.of(payment));

        Payment foundPayment = paymentService.getPaymentById(1);
        assertNotNull(foundPayment);
        assertEquals(1, foundPayment.getPaymentId());
        verify(paymentRepository, times(1)).findById(1);
    }

    @Test
    void testDeletePayment() {
        when(paymentRepository.existsById(1)).thenReturn(true);

        paymentService.deletePayment(1);
        verify(paymentRepository, times(1)).deleteById(1);
    }

    @Test
    void testUpdatePayment() {
        when(paymentRepository.existsById(1)).thenReturn(true);
        when(paymentRepository.save(any(Payment.class))).thenReturn(new Payment(1, booking, 1500.0, LocalDateTime.now(), Payment.PaymentMethod.credit_card, Payment.Status.successful));

        Payment updatedPayment = new Payment(1, booking, 1500.0, LocalDateTime.now(), Payment.PaymentMethod.credit_card, Payment.Status.successful);
        Payment result = paymentService.updatePayment(1, updatedPayment);

        assertNotNull(result);
        assertEquals(1500.0, result.getAmount());
        assertEquals("successful", result.getStatus());
        verify(paymentRepository, times(1)).existsById(1);
        verify(paymentRepository, times(1)).save(any(Payment.class));
    }


    @Test
    void testProcessPayment() {
        when(paymentRepository.save(any(Payment.class))).thenReturn(payment);

        payment.setStatus(Payment.Status.successful);
        Payment processedPayment = paymentService.processPayment(payment);
        assertNotNull(processedPayment);
        assertEquals("successful", processedPayment.getStatus());
        verify(paymentRepository, times(1)).save(payment);
    }

    @Test
    void testGetPaymentsByBookingId() {
        List<Payment> payments = Arrays.asList(payment, new Payment(2, booking, 500.0, LocalDateTime.now(), Payment.PaymentMethod.debit_card, Payment.Status.successful));
        when(paymentRepository.findByBookingBookingId(1)).thenReturn(payments);

        List<Payment> foundPayments = paymentService.getPaymentsByBookingId(1);
        assertEquals(2, foundPayments.size());
        verify(paymentRepository, times(1)).findByBookingBookingId(1);
    }
}
