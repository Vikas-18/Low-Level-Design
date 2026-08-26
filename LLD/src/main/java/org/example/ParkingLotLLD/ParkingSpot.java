package org.example.ParkingLotLLD;

import lombok.Getter;

@Getter
public class ParkingSpot {
    String id;
    SpotType spotType;
    boolean isAvailable = true;

    ParkingSpot(SpotType spotType,String id)
    {
        this.spotType = spotType;
        this.id = id;
    }


    public void parkVehicle(Vehicle vehicle)
    {
        if(vehicle.getVehicleType()==VehicleType.CAR && spotType==SpotType.CAR && isAvailable){
            isAvailable = false;
            System.out.println("Parked Successfully");

        }
        else if(vehicle.getVehicleType()==VehicleType.BIKE && spotType==SpotType.BIKE && isAvailable){
            isAvailable = false;
            System.out.println("Parked Successfully");

        }
        else if(vehicle.getVehicleType()==VehicleType.TRUCK && spotType==SpotType.TRUCK && isAvailable){
            isAvailable = false;
            System.out.println("Parked Successfully");

        }
        else {
            System.out.println("No Parking available at this moment");
        }
    }

    public void unParkVehcile(Vehicle vehicle)
    {
        isAvailable = true;
        System.out.println("Unpark Successfully");
    }
}
