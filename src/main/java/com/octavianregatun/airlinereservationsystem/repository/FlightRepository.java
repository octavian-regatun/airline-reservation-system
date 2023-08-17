package com.octavianregatun.airlinereservationsystem.repository;

import com.octavianregatun.airlinereservationsystem.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<Flight, Integer> {
}
