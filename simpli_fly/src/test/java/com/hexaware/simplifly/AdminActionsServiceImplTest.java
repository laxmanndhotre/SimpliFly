package com.hexaware.simplifly;


import com.hexaware.simplifly.entities.*;
import com.hexaware.simplifly.services.AdminActionsServiceImpl;
import com.hexaware.simplifly.services.IFlightService;
import com.hexaware.simplifly.services.IPaymentService;
import com.hexaware.simplifly.services.IRouteService;
import com.hexaware.simplifly.services.ISeatService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AdminActionsServiceImplTest {

    @InjectMocks
    private AdminActionsServiceImpl adminActionsService;

    @Mock
    private IFlightService flightService;

    @Mock
    private IRouteService routeService;

    @Mock
    private ISeatService seatService;

    @Mock
    private IPaymentService paymentService;

    private Flight flight;
    private Route route;
    private Seat seat;
    private Payment payment;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        flight = new Flight();
        flight.setFlightId(1);
        flight.setFlightName("Air India");

        route = new Route();
        route.setRouteId(1);
        route.setOrigin("City A");

        seat = new Seat();
        seat.setSeatId(1);
        seat.setSeatNumber("1A");

        payment = new Payment();
        payment.setPaymentId(1);
        payment.setAmount(100.0);
    }

    @Test
    public void testAddFlight_Success() {
        when(flightService.addFlight(flight)).thenReturn(flight);

        Flight savedFlight = adminActionsService.addFlight(flight);

        assertNotNull(savedFlight);
        assertEquals("Air India", savedFlight.getFlightName());
    }

    @Test
    public void testGetAllFlights_Success() {
        List<Flight> flights = Arrays.asList(flight);
        when(flightService.getAllFlights()).thenReturn(flights);

        List<Flight> foundFlights = adminActionsService.getAllFlights();

        assertNotNull(foundFlights);
        assertEquals(1, foundFlights.size());
    }

    @Test
    public void testGetFlightById_Success() {
        when(flightService.getFlightById(1)).thenReturn(flight);

        Flight foundFlight = adminActionsService.getFlightById(1);

        assertNotNull(foundFlight);
        assertEquals(1, foundFlight.getFlightId());
    }

    @Test
    public void testUpdateFlight_Success() {
        when(flightService.updateFlight(1, flight)).thenReturn(flight);

        Flight updatedFlight = adminActionsService.updateFlight(1, flight);

        assertNotNull(updatedFlight);
        assertEquals("Air India", updatedFlight.getFlightName());
    }

    @Test
    public void testDeleteFlight_Success() {
        adminActionsService.deleteFlight(1);

        verify(flightService, times(1)).deleteFlight(1);
    }

    @Test
    public void testAddRoute_Success() {
        when(routeService.addRoute(route)).thenReturn(route);

        Route savedRoute = adminActionsService.addRoute(route);

        assertNotNull(savedRoute);
        assertEquals("City A", savedRoute.getOrigin());
    }

    @Test
    public void testGetAllRoutes_Success() {
        List<Route> routes = Arrays.asList(route);
        when(routeService.getAllRoutes()).thenReturn(routes);

        List<Route> foundRoutes = adminActionsService.getAllRoutes();

        assertNotNull(foundRoutes);
        assertEquals(1, foundRoutes.size());
    }

    @Test
    public void testGetRouteById_Success() {
        when(routeService.getRouteById(1)).thenReturn(route);

        Route foundRoute = adminActionsService.getRouteById(1);

        assertNotNull(foundRoute);
        assertEquals(1, foundRoute.getRouteId());
    }

    @Test
    public void testUpdateRoute_Success() {
        when(routeService.updateRoute(1, route)).thenReturn(route);

        Route updatedRoute = adminActionsService.updateRoute(1, route);

        assertNotNull(updatedRoute);
        assertEquals("City A", updatedRoute.getOrigin());
    }

    @Test
    public void testDeleteRoute_Success() {
        adminActionsService.deleteRoute(1);

        verify(routeService, times(1)).deleteRoute(1);
    }

    @Test
    public void testAddSeat_Success() {
        when(seatService.addSeat(seat)).thenReturn(seat);

        Seat savedSeat = adminActionsService.addSeat(seat);

        assertNotNull(savedSeat);
        assertEquals("1A", savedSeat.getSeatNumber());
    }

    @Test
    public void testGetAllSeats_Success() {
        List<Seat> seats = Arrays.asList(seat);
        when(seatService.getAllSeats()).thenReturn(seats);

        List<Seat> foundSeats = adminActionsService.getAllSeats();

        assertNotNull(foundSeats);
        assertEquals(1, foundSeats.size());
    }

    @Test
    public void testGetSeatById_Success() {
        when(seatService.getSeatById(1)).thenReturn(seat);

        Seat foundSeat = adminActionsService.getSeatById(1);

        assertNotNull(foundSeat);
        assertEquals(1, foundSeat.getSeatId());
    }

    @Test
    public void testUpdateSeat_Success() {
        when(seatService.updateSeat(1, seat)).thenReturn(seat);

        Seat updatedSeat = adminActionsService.updateSeat(1, seat);

        assertNotNull(updatedSeat);
        assertEquals("1A", updatedSeat.getSeatNumber());
    }

    @Test
    public void testDeleteSeat_Success() {
        adminActionsService.deleteSeat(1);

        verify(seatService, times(1)).deleteSeat(1);
    }

    @Test
    public void testAddPayment_Success() {
        when(paymentService.addPayment(payment)).thenReturn(payment);

        Payment savedPayment = adminActionsService.addPayment(payment);

        assertNotNull(savedPayment);
        assertEquals(100.0, savedPayment.getAmount());
    }

    @Test
    public void testGetAllPayments_Success() {
        List<Payment> payments = Arrays.asList(payment);
        when(paymentService.getAllPayments()).thenReturn(payments);

        List<Payment> foundPayments = adminActionsService.getAllPayments();

        assertNotNull(foundPayments);
        assertEquals(1, foundPayments.size());
    }

    @Test
    public void testGetPaymentById_Success() {
        when(paymentService.getPaymentById(1)).thenReturn(payment);

        Payment foundPayment = adminActionsService.getPaymentById(1);

        assertNotNull(foundPayment);
        assertEquals(1, foundPayment.getPaymentId());
    }

    @Test
    public void testUpdatePayment_Success() {
        when(paymentService.updatePayment(1, payment)).thenReturn(payment);

        Payment updatedPayment = adminActionsService.updatePayment(1, payment);

        assertNotNull(updatedPayment);
        assertEquals(100.0, updatedPayment.getAmount());
    }

    @Test
    public void testDeletePayment_Success() {
        adminActionsService.deletePayment(1);

        verify(paymentService, times(1)).deletePayment(1);
    }
}
