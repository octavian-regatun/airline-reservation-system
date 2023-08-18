package com.octavianregatun.airlinereservationsystem.service;

import com.octavianregatun.airlinereservationsystem.entity.Flight;
import com.octavianregatun.airlinereservationsystem.rest.request.FlightRequest;
import com.octavianregatun.airlinereservationsystem.rest.response.FlightResponse;
import com.octavianregatun.airlinereservationsystem.rest.response.SeatResponse;

import java.util.List;

public interface FlightService {
    Flight findById(int id);

    Flight save(Flight flight);

    Flight save(FlightRequest flightRequest);

    List<Flight> findAll();

    float getTicketPrice(int flightId);

    void deleteById(int id);

    FlightResponse getFlightResponse(Flight flight, boolean withTickets);

    List<FlightResponse> getFlightResponseList(List<Flight> flights, boolean withTickets);

    List<SeatResponse> getUnavailableSeats(int flightId);

    List<List<SeatResponse>> getSeats(int flightId);
}
