package com.hexaware.simplifly.repositories;


//import com.hexaware.simplifly.entities.Route;
//import org.springframework.data.jpa.repository.JpaRepository;
//import java.util.List;
//
//public interface RouteRepository extends JpaRepository<Route, Integer> {
//    List<Route> findByOriginAndDestination(String origin, String destination);
//    List<Route> findByFlightId(int flightId);
//}
import com.hexaware.simplifly.entities.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RouteRepository extends JpaRepository<Route, Integer> {
    List<Route> findByOriginAndDestination(String origin, String destination);
    List<Route> findByFlightFlightId(int flightId);  
}
