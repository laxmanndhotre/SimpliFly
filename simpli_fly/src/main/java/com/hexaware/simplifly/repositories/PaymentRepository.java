package com.hexaware.simplifly.repositories;

import com.hexaware.simplifly.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {
//    List<Payment> findByBookingId(int bookingId);
    List<Payment> findByStatus(String status);
    List<Payment> findByBookingBookingId(int bookingId);
    
}
