package org.example.ParkingLotLLD.Strategy;

import org.example.ParkingLotLLD.Floors;
import org.example.ParkingLotLLD.ParkingSpot;
import org.example.ParkingLotLLD.Vehicle;

import java.util.List;

public class FirstSpot implements SpotFindingStrategy {

    @Override
    public ParkingSpot findSpot(List<Floors> floors, Vehicle vehicle) {
        for (Floors floor : floors) {
            for (ParkingSpot parkingSpot : floor.getParkingSpots()) {
                if (parkingSpot.isAvailable()) {
                    return parkingSpot;
                }
            }
        }
        return null;
    }
}
