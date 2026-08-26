package org.example.ParkingLotLLD;

import lombok.Getter;

import java.util.List;
@Getter
public class Floors {
    int floorNumber;
    List<ParkingSpot> parkingSpots;

    Floors(List<ParkingSpot> parkingSpots,int floorNumber)
    {
        this.floorNumber = floorNumber;
        this.parkingSpots = parkingSpots;
    }

}
