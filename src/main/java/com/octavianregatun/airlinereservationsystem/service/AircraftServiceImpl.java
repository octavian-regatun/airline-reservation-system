package com.octavianregatun.airlinereservationsystem.service;

import com.octavianregatun.airlinereservationsystem.entity.Aircraft;
import com.octavianregatun.airlinereservationsystem.repository.AircraftRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AircraftServiceImpl implements AircraftService {
    AircraftRepository aircraftRepository;

    AircraftServiceImpl(AircraftRepository aircraftRepository) {
        this.aircraftRepository = aircraftRepository;
    }

    @Override
    public Aircraft findById(int id) {
        return aircraftRepository.findById(id).orElse(null);
    }

    @Override
    public Aircraft save(Aircraft aircraft) {
        return aircraftRepository.save(aircraft);
    }

    @Override
    public List<Aircraft> findAll() {
        return aircraftRepository.findAll();
    }

    @Override
    public void deleteById(int id) {
        aircraftRepository.deleteById(id);
    }

    @Override
    public Aircraft update(Aircraft aircraft) {
        return aircraftRepository.save(aircraft);
    }
}
