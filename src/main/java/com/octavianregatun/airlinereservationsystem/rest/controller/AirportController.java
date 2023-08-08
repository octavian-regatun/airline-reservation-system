package com.octavianregatun.airlinereservationsystem.rest.controller;

import com.octavianregatun.airlinereservationsystem.entity.Airport;
import com.octavianregatun.airlinereservationsystem.service.AirportService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/airports")
@RestController
public class AirportController {
    AirportService airportService;

    AirportController(AirportService airportService) {
        this.airportService = airportService;
    }

    @PostMapping
    ResponseEntity<Airport> saveAirport(@RequestBody Airport airport) {
        return ResponseEntity.ok(airportService.save(airport));
    }
}
