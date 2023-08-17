package com.octavianregatun.airlinereservationsystem.entity;

import jakarta.persistence.*;

@Entity(name = "aircrafts")
public class Aircraft {
    @Id
    @GeneratedValue
    private int id;
    @Enumerated(EnumType.STRING)
    private AircraftBrand brand;
    private String name;
    private int capacity;
    @Lob
    private String image;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public AircraftBrand getBrand() {
        return brand;
    }

    public void setBrand(AircraftBrand brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
