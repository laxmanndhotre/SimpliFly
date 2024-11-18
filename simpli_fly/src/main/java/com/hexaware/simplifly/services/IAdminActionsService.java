package com.hexaware.simplifly.services;


import com.hexaware.simplifly.entities.Flight;
import com.hexaware.simplifly.entities.Route;
import com.hexaware.simplifly.entities.Seat;
import com.hexaware.simplifly.entities.Payment;
import java.util.List;

public interface IAdminActionsService {

    Flight addFlight(Flight flight);

    List<Flight> getAllFlights();

    Flight getFlightById(int id);

    void deleteFlight(int id);

    Flight updateFlight(int id, Flight flight);

    Route addRoute(Route route);

    List<Route> getAllRoutes();

    Route getRouteById(int id);

    void deleteRoute(int id);

    Route updateRoute(int id, Route route);

    Seat addSeat(Seat seat);

    List<Seat> getAllSeats();

    Seat getSeatById(int id);

    void deleteSeat(int id);

    Seat updateSeat(int id, Seat seat);

    Payment addPayment(Payment payment);

    List<Payment> getAllPayments();

    Payment getPaymentById(int id);

    void deletePayment(int id);

    Payment updatePayment(int id, Payment payment);
}
