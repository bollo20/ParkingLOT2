package org.example.parkinglot.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Cars extends User {
    @OneToMany(mappedBy = "owner", orphanRemoval = true)
    private List<Cars> car = new ArrayList<>();

    @Column(name = "parking_spot")
    private String parkingSpot;

    @Column(name = "license_plate")
    private String licensePlate;

    @Column(name = "cars")
    private Long cars;

    @ManyToOne(optional = false)
    @JoinColumn(name = "owner_id", nullable = false)
    private Cars owner;

    public List<Cars> getCar() {
        return car;
    }

    public void setCar(List<Cars> car) {
        this.car = car;
    }

    public Cars getOwner() {
        return owner;
    }

    public void setOwner(Cars owner) {
        this.owner = owner;
    }

    public String getParkingSpot() {
        return parkingSpot;
    }

    public void setParkingSpot(String parkingSpot) {
        this.parkingSpot = parkingSpot;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public Long getCars() {
        return cars;
    }

    public void setCars(Long cars) {
        this.cars = cars;
    }
}