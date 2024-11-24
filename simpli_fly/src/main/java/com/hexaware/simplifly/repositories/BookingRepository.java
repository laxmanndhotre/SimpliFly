package com.hexaware.simplifly.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hexaware.simplifly.entities.Booking;



public interface BookingRepository extends JpaRepository<Booking, Integer> {
    List<Booking> findByUserUserId(int userId);   
    List<Booking> findByRouteRouteId(int routeId); 
}

