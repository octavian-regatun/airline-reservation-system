package com.octavianregatun.airlinereservationsystem.repository;

import com.octavianregatun.airlinereservationsystem.entity.Airport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirportRepository extends JpaRepository<Airport, Integer> {
}
