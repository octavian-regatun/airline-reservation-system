package com.octavianregatun.airlinereservationsystem.rest.controller;

import com.octavianregatun.airlinereservationsystem.entity.Ticket;
import com.octavianregatun.airlinereservationsystem.rest.request.TicketRequest;
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
    ResponseEntity<List<Ticket>> saveTickets(@RequestBody List<TicketRequest> ticketRequests) {
        return ResponseEntity.ok(ticketService.save(ticketRequests));
    }

    @GetMapping
    ResponseEntity<List<Ticket>> findAll() {
        return ResponseEntity.ok(ticketService.findAll());
    }

    @GetMapping("{id}")
    ResponseEntity<Ticket> findById(@PathVariable int id) {
        return ResponseEntity.ok(ticketService.findById(id));
    }

    @DeleteMapping("{id}")
    ResponseEntity<Void> delete(@PathVariable int id) {
        ticketService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
