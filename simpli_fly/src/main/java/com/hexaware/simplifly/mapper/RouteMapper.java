package com.hexaware.simplifly.mapper;


import com.hexaware.simplifly.dto.RouteDTO;
import com.hexaware.simplifly.entities.Route;

public class RouteMapper {

    public static RouteDTO toDTO(Route route) {
        RouteDTO routeDTO = new RouteDTO();
        routeDTO.setRouteId(route.getRouteId());
        routeDTO.setFlightId(route.getFlight().getFlightId());
        routeDTO.setOrigin(route.getOrigin());
        routeDTO.setDestination(route.getDestination());
        routeDTO.setDepartureTime(route.getDepartureTime());
        routeDTO.setArrivalTime(route.getArrivalTime());
        routeDTO.setFare(route.getFare());
        routeDTO.setAvailableSeats(route.getAvailableSeats());
        return routeDTO;
    }

    public static Route toEntity(RouteDTO routeDTO) {
        Route route = new Route();
        route.setRouteId(routeDTO.getRouteId());
        // Additional setup for Flight required
        route.setOrigin(routeDTO.getOrigin());
        route.setDestination(routeDTO.getDestination());
        route.setDepartureTime(routeDTO.getDepartureTime());
        route.setArrivalTime(routeDTO.getArrivalTime());
        route.setFare(routeDTO.getFare());
        route.setAvailableSeats(routeDTO.getAvailableSeats());
        return route;
    }
}
