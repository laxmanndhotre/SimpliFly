
package com.hexaware.simplifly.services;

import com.hexaware.simplifly.entities.Route;
import com.hexaware.simplifly.exceptions.ResourceNotFoundException;
import com.hexaware.simplifly.repositories.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RouteServiceImpl implements RouteService {

    @Autowired
    private RouteRepository routeRepository;

    @Override
    public Route addRoute(Route route) {
       
        return routeRepository.save(route);
    }

    @Override
    public List<Route> getRoutesByOriginAndDestination(String origin, String destination) {
        return routeRepository.findByOriginAndDestination(origin, destination);
    }

    @Override
    public Route getRouteById(int id) {
        try {
			return routeRepository.findById(id)
			        .orElseThrow(() -> new ResourceNotFoundException("Route not found with ID: " + id));
		} catch (ResourceNotFoundException e) {
			
		}
		return null;
    }


    @Override
    public void deleteRoute(int id) {
    	try {
        if (!routeRepository.existsById(id)) {
            throw new ResourceNotFoundException("Route not found with ID: " + id);
        }
        routeRepository.deleteById(id);
        }
    	catch(ResourceNotFoundException rnfe) {
    		
    	}
    	
    }

    @Override
    public Route updateRoute(int id, Route route) {
        Route existingRoute;
		try {
			existingRoute = routeRepository.findById(id)
			        .orElseThrow(() -> new ResourceNotFoundException("Route not found with ID: " + id));
		
        existingRoute.setFlight(route.getFlight());
        existingRoute.setOrigin(route.getOrigin());
        existingRoute.setDestination(route.getDestination());
        existingRoute.setDepartureTime(route.getDepartureTime());
        existingRoute.setArrivalTime(route.getArrivalTime());
        existingRoute.setFare(route.getFare());
        existingRoute.setAvailableSeats(route.getAvailableSeats());
        existingRoute.setUpdatedAt(LocalDateTime.now());

        return routeRepository.save(existingRoute);
		} 
		catch (ResourceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
    }

	@Override
	public List<Route> getAllRoutes() {
		routeRepository.findAll();
		return null;
	}

}
