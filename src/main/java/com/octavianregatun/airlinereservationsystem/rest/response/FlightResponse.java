package com.octavianregatun.airlinereservationsystem.rest.response;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.octavianregatun.airlinereservationsystem.entity.Aircraft;
import com.octavianregatun.airlinereservationsystem.entity.Airport;
import com.octavianregatun.airlinereservationsystem.entity.Ticket;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class FlightResponse {
    private int id;

    private Aircraft aircraft;

    private Airport departureAirport;

    private LocalDateTime departureTime;

    private Airport arrivalAirport;

    private LocalDateTime arrivalTime;

    private float price;

    private int totalSeats;

    private int availableSeats;

    private List<TicketResponse> tickets = null;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Aircraft getAircraft() {
        return aircraft;
    }

    public void setAircraft(Aircraft aircraft) {
        this.aircraft = aircraft;
    }

    public Airport getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirport(Airport departureAirport) {
        this.departureAirport = departureAirport;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }

    public Airport getArrivalAirport() {
        return arrivalAirport;
    }

    public void setArrivalAirport(Airport arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalDateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public List<TicketResponse> getTickets() {
        return tickets;
    }

    public void setTickets(List<TicketResponse> tickets) {
        this.tickets = tickets;
    }
}
