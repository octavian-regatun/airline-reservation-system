package com.octavianregatun.airlinereservationsystem.rest.controller;

import com.octavianregatun.airlinereservationsystem.entity.Flight;
import com.octavianregatun.airlinereservationsystem.rest.request.FlightRequest;
import com.octavianregatun.airlinereservationsystem.service.FlightService;
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
    public List<Flight> findAll() {
        return flightService.findAll();
    }

    @GetMapping("{id}")
    public Flight findById(@PathVariable int id) {
        return flightService.findById(id);
    }

    @PostMapping
    public Flight save(@RequestBody FlightRequest flight) {
        return flightService.save(flight);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable int id) {
        flightService.deleteById(id);
    }
}
