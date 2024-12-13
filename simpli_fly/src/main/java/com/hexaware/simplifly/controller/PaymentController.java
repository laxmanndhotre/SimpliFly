package com.hexaware.simplifly.controller;

import com.hexaware.simplifly.entities.Payment;
import com.hexaware.simplifly.services.IPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    @Autowired
    private IPaymentService paymentService;
    @CrossOrigin(origins = "http://localhost:4200") 
    @PostMapping
    public ResponseEntity<Payment> addPayment(@RequestBody Payment payment) {
        Payment newPayment = paymentService.addPayment(payment);
        return ResponseEntity.ok(newPayment);
    }
    @CrossOrigin(origins = "http://localhost:4200") 
    @GetMapping
    public ResponseEntity<List<Payment>> getAllPayments() {
        List<Payment> payments = paymentService.getAllPayments();
        return ResponseEntity.ok(payments);
    }
    @CrossOrigin(origins = "http://localhost:4200") 
    @GetMapping("/{id}")
    public ResponseEntity<Payment> getPaymentById(@PathVariable int id) {
        Payment payment = paymentService.getPaymentById(id);
        return ResponseEntity.ok(payment);
    }
    @CrossOrigin(origins = "http://localhost:4200") 
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePayment(@PathVariable int id) {
        paymentService.deletePayment(id);
        return ResponseEntity.noContent().build();
    }
    @CrossOrigin(origins = "http://localhost:4200") 
    @PutMapping("/{id}")
    public ResponseEntity<Payment> updatePayment(@PathVariable int id, @RequestBody Payment payment) {
        Payment updatedPayment = paymentService.updatePayment(id, payment);
        return ResponseEntity.ok(updatedPayment);
    }
    @CrossOrigin(origins = "http://localhost:4200") 
    @PostMapping("/process")
    public ResponseEntity<Payment> processPayment(@RequestBody Payment payment) {
        Payment processedPayment = paymentService.processPayment(payment);
        return ResponseEntity.ok(processedPayment);
    }
    @CrossOrigin(origins = "http://localhost:4200") 
    @GetMapping("/booking/{bookingId}")
    public ResponseEntity<List<Payment>> getPaymentsByBookingId(@PathVariable int bookingId) {
        List<Payment> payments = paymentService.getPaymentsByBookingId(bookingId);
        return ResponseEntity.ok(payments);
    }
}
