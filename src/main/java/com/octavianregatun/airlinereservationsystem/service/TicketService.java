package com.octavianregatun.airlinereservationsystem.service;

import com.octavianregatun.airlinereservationsystem.entity.Ticket;
import com.octavianregatun.airlinereservationsystem.rest.request.TicketRequest;
import com.octavianregatun.airlinereservationsystem.rest.response.TicketResponse;

import java.util.List;

public interface TicketService {
    Ticket findById(int id);

    Ticket save(Ticket ticket);

    List<Ticket> save(List<TicketRequest> tickets);

    List<Ticket> findAll();

    List<Ticket> findByFlightId(int flightId);

    List<Ticket> findByFlightIdAndUserId(int flightId, int userId);

    void deleteById(int id);

    TicketResponse getTicketResponse(Ticket ticket, boolean withFlight);

    List<TicketResponse> getTicketResponses(List<Ticket> tickets, boolean withFlight);

    List<Ticket> findByUserId(int userId);
}
