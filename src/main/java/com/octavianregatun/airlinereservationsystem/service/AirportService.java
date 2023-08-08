package com.octavianregatun.airlinereservationsystem.service;

import com.octavianregatun.airlinereservationsystem.entity.Aircraft;
import com.octavianregatun.airlinereservationsystem.entity.Airport;

import java.util.List;

public interface AirportService {
    Airport findById(int id);

    Airport save(Airport airport);

    List<Airport> findAll();

    void deleteById(int id);
}
