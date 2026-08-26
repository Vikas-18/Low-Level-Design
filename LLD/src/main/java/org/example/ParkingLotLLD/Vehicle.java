package org.example.ParkingLotLLD;

import lombok.Getter;

@Getter
public class Vehicle {
    String vehicleNumber;
    VehicleType vehicleType;

    Vehicle(String vehicleNumber, VehicleType vehicleType)
    {
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
    }

}
