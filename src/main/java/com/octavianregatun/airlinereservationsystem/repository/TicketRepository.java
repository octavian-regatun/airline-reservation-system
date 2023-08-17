package com.octavianregatun.airlinereservationsystem.repository;

import com.octavianregatun.airlinereservationsystem.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {
}
