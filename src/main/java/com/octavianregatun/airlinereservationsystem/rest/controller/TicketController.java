package com.octavianregatun.airlinereservationsystem.rest.controller;

import com.octavianregatun.airlinereservationsystem.entity.Ticket;
import com.octavianregatun.airlinereservationsystem.rest.request.TicketRequest;
import com.octavianregatun.airlinereservationsystem.rest.response.TicketResponse;
import com.octavianregatun.airlinereservationsystem.service.TicketService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/tickets")
@RestController
public class TicketController {
    TicketService ticketService;

    TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @PostMapping
    ResponseEntity<List<TicketResponse>> saveTickets(@RequestBody List<TicketRequest> ticketRequests) {
        return ResponseEntity.ok(ticketService.getTicketResponses(ticketService.save(ticketRequests), true));
    }

    @GetMapping
    ResponseEntity<List<TicketResponse>> findAll() {
        return ResponseEntity.ok(ticketService.getTicketResponses(ticketService.findAll(), true));
    }

    @GetMapping(params = "flightId")
    ResponseEntity<List<TicketResponse>> findByFlightId(@RequestParam int flightId) {
        return ResponseEntity.ok(ticketService.getTicketResponses(ticketService.findByFlightId(flightId), true));
    }

    @GetMapping(params = {"flightId", "userId"})
    ResponseEntity<List<TicketResponse>> findByFlightId(@RequestParam int flightId, @RequestParam int userId) {
        return ResponseEntity.ok(ticketService.getTicketResponses(ticketService.findByFlightIdAndUserId(flightId, userId), true));
    }

    @GetMapping(params = {"userId"})
    ResponseEntity<List<TicketResponse>> findByUserId(@RequestParam int userId) {
        return ResponseEntity.ok(ticketService.getTicketResponses(ticketService.findByUserId(userId), true));
    }

    @GetMapping("{id}")
    ResponseEntity<TicketResponse> findById(@PathVariable int id) {
        return ResponseEntity.ok(ticketService.getTicketResponse(ticketService.findById(id), true));
    }

    @DeleteMapping("{id}")
    ResponseEntity<Void> delete(@PathVariable int id) {
        ticketService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
