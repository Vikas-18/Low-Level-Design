package org.example.ParkingLotLLD;

import org.example.ParkingLotLLD.Strategy.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Setup parking lot
        ParkingSpot carSpot  = new ParkingSpot(SpotType.CAR,  "SPOT-001");
        ParkingSpot bikeSpot = new ParkingSpot(SpotType.BIKE, "SPOT-002");

        List<ParkingSpot> spotsFloor1 = new ArrayList<>();
        spotsFloor1.add(carSpot);
        spotsFloor1.add(bikeSpot);

        Floors floor1 = new Floors(spotsFloor1, 1);

        List<Floors> floorList = new ArrayList<>();
        floorList.add(floor1);

        ParkingLot parkingLot = new ParkingLot(
                floorList,
                new FirstSpot(),
                new HourlyPricing(20)  // dynamic pricing based on vehicle + floor
        );

        // Park a car
        Vehicle car = new Vehicle("MH-01-AB-1234", VehicleType.CAR);
        Ticket ticket = parkingLot.park(car);

        // Unpark and pay via UPI
        if (ticket != null) {
            parkingLot.unPark(ticket, new UPI());
            parkingLot.unPark(ticket, new UPI());
        }
    }
}
