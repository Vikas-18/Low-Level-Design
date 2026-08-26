package org.example.ParkingLotLLD;

import org.example.ParkingLotLLD.Strategy.FirstSpot;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle("TGDSFSDF",VehicleType.CAR);
        ParkingSpot parkingSpot = new ParkingSpot(SpotType.CAR,"sdfsdfsd");
        List<ParkingSpot> listOfParkingSpot  = new ArrayList<>();
        listOfParkingSpot.add(parkingSpot);
        Floors floor = new Floors(listOfParkingSpot,1);
        List<Floors> floorList = new ArrayList<>();
        floorList.add(floor);
        ParkingLot parkingLot = new ParkingLot(floorList,new FirstSpot());
        parkingLot.park(vehicle);
        parkingLot.unPark(vehicle);
    }






















}
