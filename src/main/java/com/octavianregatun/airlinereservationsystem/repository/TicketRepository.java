package com.octavianregatun.airlinereservationsystem.repository;

import com.octavianregatun.airlinereservationsystem.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {
    List<Ticket> findByFlightId(int flightId);

    List<Ticket> findByFlightIdAndUserId(int flightId, int userId);
}
