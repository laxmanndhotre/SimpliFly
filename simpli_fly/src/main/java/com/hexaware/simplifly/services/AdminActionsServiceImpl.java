package com.hexaware.simplifly.services;


import com.hexaware.simplifly.entities.Flight;
import com.hexaware.simplifly.entities.Route;
import com.hexaware.simplifly.entities.Seat;
import com.hexaware.simplifly.entities.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AdminActionsServiceImpl implements AdminActionsService {

    @Autowired
    private FlightService flightService;

    @Autowired
    private RouteService routeService;

    @Autowired
    private SeatService seatService;

    @Autowired
    private PaymentService paymentService;

    @Override
    public Flight addFlight(Flight flight) {
        return flightService.addFlight(flight);
    }

    @Override
    public List<Flight> getAllFlights() {
        return flightService.getAllFlights();
    }

    @Override
    public Flight getFlightById(int id) {
        return flightService.getFlightById(id);
    }

    @Override
    public void deleteFlight(int id) {
        flightService.deleteFlight(id);
    }

    @Override
    public Flight updateFlight(int id, Flight flight) {
        return flightService.updateFlight(id, flight);
    }

    @Override
    public Route addRoute(Route route) {
        return routeService.addRoute(route);
    }

    @Override
    public List<Route> getAllRoutes() {
        return routeService.getAllRoutes();
    }

    @Override
    public Route getRouteById(int id) {
        return routeService.getRouteById(id);
    }

    @Override
    public void deleteRoute(int id) {
        routeService.deleteRoute(id);
    }

    @Override
    public Route updateRoute(int id, Route route) {
        return routeService.updateRoute(id, route);
    }

    @Override
    public Seat addSeat(Seat seat) {
        return seatService.addSeat(seat);
    }

    @Override
    public List<Seat> getAllSeats() {
        return seatService.getAllSeats();
    }

    @Override
    public Seat getSeatById(int id) {
        return seatService.getSeatById(id);
    }

    @Override
    public void deleteSeat(int id) {
        seatService.deleteSeat(id);
    }

    @Override
    public Seat updateSeat(int id, Seat seat) {
        return seatService.updateSeat(id, seat);
    }

    @Override
    public Payment addPayment(Payment payment) {
        return paymentService.addPayment(payment);
    }

    @Override
    public List<Payment> getAllPayments() {
        return paymentService.getAllPayments();
    }

    @Override
    public Payment getPaymentById(int id) {
        return paymentService.getPaymentById(id);
    }

    @Override
    public void deletePayment(int id) {
        paymentService.deletePayment(id);
    }

    @Override
    public Payment updatePayment(int id, Payment payment) {
        return paymentService.updatePayment(id, payment);
    }
}
