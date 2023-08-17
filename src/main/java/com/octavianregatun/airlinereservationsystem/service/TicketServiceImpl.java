package com.octavianregatun.airlinereservationsystem.service;

import com.octavianregatun.airlinereservationsystem.entity.Aircraft;
import com.octavianregatun.airlinereservationsystem.entity.Ticket;
import com.octavianregatun.airlinereservationsystem.repository.AircraftRepository;
import com.octavianregatun.airlinereservationsystem.repository.TicketRepository;
import com.octavianregatun.airlinereservationsystem.rest.request.TicketRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {
    TicketRepository ticketRepository;
    FlightService flightService;
    UserService userService;


    TicketServiceImpl(TicketRepository ticketRepository, FlightService flightService, UserService userService) {
        this.ticketRepository = ticketRepository;
        this.flightService = flightService;
        this.userService = userService;
    }

    @Override
    public Ticket findById(int id) {
        return ticketRepository.findById(id).orElse(null);
    }

    @Override
    public Ticket save(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    @Override
    public List<Ticket> save(List<TicketRequest> ticketRequests) {
        var tickets = ticketRequests.stream().map(ticketRequest -> {
            Ticket ticket = new Ticket();

            ticket.setFirstName(ticketRequest.getFirstName());
            ticket.setLastName(ticketRequest.getLastName());
            ticket.setEmail(ticketRequest.getEmail());
            ticket.setFlight(flightService.findById(ticketRequest.getFlightId()));
            ticket.setUser(userService.findById(ticketRequest.getUserId()));
            ticket.setSeatColumn(ticketRequest.getSeatColumn());
            ticket.setSeatRow(ticketRequest.getSeatRow());
            ticket.setPrice(flightService.getTicketPrice(ticketRequest.getFlightId()));

            return ticket;
        }).toList();

        return ticketRepository.saveAll(tickets);
    }

    @Override
    public List<Ticket> findAll() {
        return ticketRepository.findAll();
    }

    @Override
    public void deleteById(int id) {
        ticketRepository.deleteById(id);
    }
}
