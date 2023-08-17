package com.octavianregatun.airlinereservationsystem.rest.controller;

import com.octavianregatun.airlinereservationsystem.entity.Airport;
import com.octavianregatun.airlinereservationsystem.service.AirportService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/airports")
@RestController
public class AirportController {
    AirportService airportService;

    AirportController(AirportService airportService) {
        this.airportService = airportService;
    }

    @GetMapping
    ResponseEntity<List<Airport>> getAirports() {
        return ResponseEntity.ok(airportService.findAll());
    }

    @GetMapping("{id}")
    ResponseEntity<Airport> getAirport(@PathVariable Integer id) {
        return ResponseEntity.ok(airportService.findById(id));
    }

    @PostMapping
    ResponseEntity<Airport> saveAirport(@RequestBody Airport airport) {
        return ResponseEntity.ok(airportService.save(airport));
    }

    @DeleteMapping("{id}")
    ResponseEntity<Void> deleteAirport(@PathVariable Integer id) {
        airportService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
