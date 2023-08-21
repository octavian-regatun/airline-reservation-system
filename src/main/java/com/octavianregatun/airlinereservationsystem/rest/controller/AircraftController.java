package com.octavianregatun.airlinereservationsystem.rest.controller;

import com.octavianregatun.airlinereservationsystem.entity.Aircraft;
import com.octavianregatun.airlinereservationsystem.service.AircraftService;
import com.octavianregatun.airlinereservationsystem.service.AircraftServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/aircrafts")
@RestController
public class AircraftController {
    AircraftService aircraftService;

    AircraftController(AircraftService aircraftService) {
        this.aircraftService = aircraftService;
    }

    @PostMapping
    ResponseEntity<Aircraft> saveAircraft(@RequestBody Aircraft aircraft) {
        return ResponseEntity.ok(aircraftService.save(aircraft));
    }

    @GetMapping
    ResponseEntity<List<Aircraft>> findAll() {
        return ResponseEntity.ok(aircraftService.findAll());
    }

    @GetMapping("{id}")
    ResponseEntity<Aircraft> findById(@PathVariable int id) {
        return ResponseEntity.ok(aircraftService.findById(id));
    }

    @DeleteMapping("{id}")
    ResponseEntity delete(@PathVariable int id) {
        aircraftService.deleteById(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    ResponseEntity<Aircraft> update(@RequestBody Aircraft aircraft) {
        return ResponseEntity.ok(aircraftService.update(aircraft));
    }
}
