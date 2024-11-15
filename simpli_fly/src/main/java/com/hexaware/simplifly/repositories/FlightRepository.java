package com.hexaware.simplifly.repositories;

import com.hexaware.simplifly.entities.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, Integer> {
    List<Flight> findByOwnerId(int ownerId);
}