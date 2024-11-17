package com.hexaware.simplifly.controller;

import com.hexaware.simplifly.entities.Route;
import com.hexaware.simplifly.services.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/routes")
public class RouteController {

    @Autowired
    private RouteService routeService;

    @GetMapping
    public ResponseEntity<List<Route>> getAllRoutes() {
        List<Route> routes = routeService.getAllRoutes();
        return new ResponseEntity<>(routes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Route> getRouteById(@PathVariable int id) {
        Route route = routeService.getRouteById(id);
        return new ResponseEntity<>(route, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Route> addRoute(@RequestBody Route route) {
        Route newRoute = routeService.addRoute(route);
        return new ResponseEntity<>(newRoute, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Route> updateRoute(@PathVariable int id, @RequestBody Route route) {
        Route updatedRoute = routeService.updateRoute(id, route);
        return new ResponseEntity<>(updatedRoute, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRoute(@PathVariable int id) {
        routeService.deleteRoute(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
