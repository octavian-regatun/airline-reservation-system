package com.octavianregatun.airlinereservationsystem.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "airports")
public class Airport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "location_id")
    private Location location;
    private String country;
    private String municipality;
    @Column(name = "gps_code")
    private String gpsCode;
    @Column(name = "iata_code")
    private String iataCode;
    @Enumerated(EnumType.STRING)
    private AirportType type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getMunicipality() {
        return municipality;
    }

    public void setMunicipality(String municipality) {
        this.municipality = municipality;
    }

    public String getGpsCode() {
        return gpsCode;
    }

    public void setGpsCode(String gpsCode) {
        this.gpsCode = gpsCode;
    }

    public String getIataCode() {
        return iataCode;
    }

    public void setIataCode(String iataCode) {
        this.iataCode = iataCode;
    }

    public AirportType getType() {
        return type;
    }

    public void setType(AirportType type) {
        this.type = type;
    }

    public Airport() {
    }

    public Airport(int id, String name, Location location, String country, String municipality, String gpsCode, String iataCode, AirportType type) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.country = country;
        this.municipality = municipality;
        this.gpsCode = gpsCode;
        this.iataCode = iataCode;
        this.type = type;
    }
}
