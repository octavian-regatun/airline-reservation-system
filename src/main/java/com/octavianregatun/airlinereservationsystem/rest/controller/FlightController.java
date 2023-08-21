package com.octavianregatun.airlinereservationsystem.rest.controller;

import com.octavianregatun.airlinereservationsystem.entity.Flight;
import com.octavianregatun.airlinereservationsystem.rest.request.FlightRequest;
import com.octavianregatun.airlinereservationsystem.rest.response.FlightResponse;
import com.octavianregatun.airlinereservationsystem.rest.response.SeatResponse;
import com.octavianregatun.airlinereservationsystem.service.FlightService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("flights")
public class FlightController {
    FlightService flightService;

    FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping
    public ResponseEntity<List<FlightResponse>> findAll(@RequestParam(required = false) Float maximumPrice) {
        List<Flight> flights = flightService.findAll();
        if (maximumPrice != null)
            flights = flightService.filterByMaximumPrice(flights, maximumPrice);
        return ResponseEntity.ok(flightService.getFlightResponseList(flights, true));
    }


    @GetMapping("{id}")
    public ResponseEntity<FlightResponse> findById(@PathVariable int id) {
        return ResponseEntity.ok(flightService.getFlightResponse(flightService.findById(id), true));
    }

    @PostMapping
    public ResponseEntity<FlightResponse> save(@RequestBody FlightRequest flight) {
        return ResponseEntity.ok(flightService.getFlightResponse(flightService.save(flight), true));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteById(@PathVariable int id) {
        flightService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("{id}/seats")
    public ResponseEntity<List<List<SeatResponse>>> getSeats(@PathVariable int id) {
        return ResponseEntity.ok(flightService.getSeats(id));
    }
}
