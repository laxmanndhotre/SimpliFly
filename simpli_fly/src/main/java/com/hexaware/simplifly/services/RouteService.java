

package com.hexaware.simplifly.services;

import com.hexaware.simplifly.entities.Route;
import com.hexaware.simplifly.repositories.RouteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RouteService {

    public static final RouteRepository routeRepository = null;

    public Route addRoute(Route route);

    public List<Route> getRoutesByOriginAndDestination(String origin, String destination);

    public Route getRouteById(int id);

    public void deleteRoute(int id);

	public List<Route> getAllRoutes();

	public Route updateRoute(int id, Route route);
}
