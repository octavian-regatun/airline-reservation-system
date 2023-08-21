package com.octavianregatun.airlinereservationsystem.service;

import com.octavianregatun.airlinereservationsystem.entity.Aircraft;

import java.util.List;

public interface AircraftService {
    Aircraft findById(int id);

    Aircraft save(Aircraft aircraft);

    List<Aircraft> findAll();

    void deleteById(int id);

    Aircraft update(Aircraft aircraft);
}
