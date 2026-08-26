package org.example.ParkingLotLLD.Strategy;

import org.example.ParkingLotLLD.Floors;
import org.example.ParkingLotLLD.ParkingSpot;
import org.example.ParkingLotLLD.Vehicle;

import java.util.List;

public interface SpotFindingStrategy {
    ParkingSpot findSpot(List<Floors> floors, Vehicle vehicle);
}
