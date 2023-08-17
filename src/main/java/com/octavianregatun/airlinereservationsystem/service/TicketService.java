package com.octavianregatun.airlinereservationsystem.service;

import com.octavianregatun.airlinereservationsystem.entity.Ticket;
import com.octavianregatun.airlinereservationsystem.rest.request.TicketRequest;

import java.util.List;

public interface TicketService {
    Ticket findById(int id);

    Ticket save(Ticket ticket);

    List<Ticket> save(List<TicketRequest> tickets);

    List<Ticket> findAll();

    void deleteById(int id);
}
