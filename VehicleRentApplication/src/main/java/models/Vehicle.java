package models;

import models.VehicleType;

public class Vehicle {
    public String number;
    public VehicleType vehicleType;

    public Vehicle() {
    }

    public Vehicle(String number, VehicleType vehicleType) {
        this.number = number;
        this.vehicleType = vehicleType;
    }
}
