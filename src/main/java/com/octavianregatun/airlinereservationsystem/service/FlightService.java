package com.octavianregatun.airlinereservationsystem.service;

import com.octavianregatun.airlinereservationsystem.entity.Flight;
import com.octavianregatun.airlinereservationsystem.rest.request.FlightRequest;

import java.util.List;

public interface FlightService {
    Flight findById(int id);

    Flight save(Flight flight);

    Flight save(FlightRequest flightRequest);

    List<Flight> findAll();

    float getTicketPrice(int flightId);

    void deleteById(int id);
}
