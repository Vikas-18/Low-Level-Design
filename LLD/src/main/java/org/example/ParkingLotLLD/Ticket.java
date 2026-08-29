package org.example.ParkingLotLLD;

import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
public class Ticket {    String ticketId;
    Vehicle vehicle;
    ParkingSpot parkingSpot;
    int floorNumber;
    LocalDateTime entryTime;

    public Ticket(Vehicle vehicle, ParkingSpot parkingSpot, int floorNumber) {
        this.ticketId = UUID.randomUUID().toString();
        this.vehicle = vehicle;
        this.parkingSpot = parkingSpot;
        this.floorNumber = floorNumber;
        this.entryTime = LocalDateTime.now();
    }
}
