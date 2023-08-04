package com.octavianregatun.airlinereservationsystem.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "locations")
public class Location {
    @Id
    @GeneratedValue
    int id;
    double latitude;
    double longitude;

    public Location() {
    }

    public Location(double latitude, double longitude) {
        id = 0;
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
