package com.hexaware.simplifly;


import com.hexaware.simplifly.entities.Route;
import com.hexaware.simplifly.exceptions.ResourceNotFoundException;
import com.hexaware.simplifly.repositories.RouteRepository;
import com.hexaware.simplifly.services.RouteServiceImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class RouteServiceImplTest {

    @InjectMocks
    private RouteServiceImpl routeService;

    @Mock
    private RouteRepository routeRepository;

    private Route route;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        route = new Route();
        route.setRouteId(1);
        route.setOrigin("City A");
    }

    @Test
    public void testGetRouteById_Success() {
        when(routeRepository.findById(1)).thenReturn(Optional.of(route));

        Route foundRoute = routeService.getRouteById(1);

        assertNotNull(foundRoute);
        assertEquals(1, foundRoute.getRouteId());
    }

   

    @Test
    public void testAddRoute_Success() {
        when(routeRepository.save(route)).thenReturn(route);

        Route savedRoute = routeService.addRoute(route);

        assertNotNull(savedRoute);
        assertEquals("City A", savedRoute.getOrigin());
    }
}
