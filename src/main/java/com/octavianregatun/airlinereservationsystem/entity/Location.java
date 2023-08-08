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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public Location() {
    }

    public Location(double latitude, double longitude) {
        id = 0;
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
