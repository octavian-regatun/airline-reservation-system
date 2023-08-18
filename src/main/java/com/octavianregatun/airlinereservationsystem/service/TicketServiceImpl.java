package com.octavianregatun.airlinereservationsystem.service;

import com.octavianregatun.airlinereservationsystem.entity.Ticket;
import com.octavianregatun.airlinereservationsystem.repository.TicketRepository;
import com.octavianregatun.airlinereservationsystem.rest.request.TicketRequest;
import com.octavianregatun.airlinereservationsystem.rest.response.FlightResponse;
import com.octavianregatun.airlinereservationsystem.rest.response.TicketResponse;
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
    public List<Ticket> findByFlightId(int flightId) {
        return ticketRepository.findByFlightId(flightId);
    }

    @Override
    public List<Ticket> findByFlightIdAndUserId(int flightId, int userId) {
        flightService.findById(flightId);
        userService.findById(userId);

        return ticketRepository.findByFlightIdAndUserId(flightId, userId);
    }

    @Override
    public void deleteById(int id) {
        ticketRepository.deleteById(id);
    }

    @Override
    public TicketResponse getTicketResponse(Ticket ticket, boolean withFlight) {
        TicketResponse ticketResponse = new TicketResponse();

        ticketResponse.setId(ticket.getId());
        ticketResponse.setFirstName(ticket.getFirstName());
        ticketResponse.setLastName(ticket.getLastName());
        ticketResponse.setEmail(ticket.getEmail());
        ticketResponse.setSeatRow(ticket.getSeatRow());
        ticketResponse.setSeatColumn(ticket.getSeatColumn());
        ticketResponse.setPrice(ticket.getPrice());
        ticketResponse.setUser(userService.getUserResponse(ticket.getUser()));
        if (withFlight) {
            FlightResponse flightResponse = flightService.getFlightResponse(ticket.getFlight(), false);
            ticketResponse.setFlight(flightResponse);
        }
        return ticketResponse;
    }

    @Override
    public List<TicketResponse> getTicketResponses(List<Ticket> tickets, boolean withFlight) {
        List<TicketResponse> ticketResponses = new ArrayList<>();

        for (Ticket ticket : tickets) {
            ticketResponses.add(getTicketResponse(ticket, withFlight));
        }

        return ticketResponses;
    }
}
