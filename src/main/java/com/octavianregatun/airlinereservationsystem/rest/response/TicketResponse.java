package com.octavianregatun.airlinereservationsystem.rest.response;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.octavianregatun.airlinereservationsystem.entity.Flight;
import com.octavianregatun.airlinereservationsystem.entity.User;
import jakarta.persistence.*;

public class TicketResponse {

    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private FlightResponse flight;
    private UserResponse user;
    private char seatColumn;
    private int seatRow;
    private float price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public FlightResponse getFlight() {
        return flight;
    }

    public void setFlight(FlightResponse flight) {
        this.flight = flight;
    }

    public UserResponse getUser() {
        return user;
    }

    public void setUser(UserResponse user) {
        this.user = user;
    }

    public char getSeatColumn() {
        return seatColumn;
    }

    public void setSeatColumn(char seatColumn) {
        this.seatColumn = seatColumn;
    }

    public int getSeatRow() {
        return seatRow;
    }

    public void setSeatRow(int seatRow) {
        this.seatRow = seatRow;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
