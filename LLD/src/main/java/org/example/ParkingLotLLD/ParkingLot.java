package org.example.ParkingLotLLD;

import lombok.Getter;
import org.example.ParkingLotLLD.Strategy.SpotFindingStrategy;

import java.util.List;
@Getter
public class ParkingLot {
    List<Floors> floors;
    SpotFindingStrategy spotFindingStrategy;
    ParkingLot(List<Floors> floors,SpotFindingStrategy spotFindingStrategy)
    {
        this.floors = floors;
        this.spotFindingStrategy = spotFindingStrategy;
    }

    public void park(Vehicle vehicle)
    {
        ParkingSpot spot = spotFindingStrategy.findSpot(floors, vehicle);
        if (spot != null) {
            spot.parkVehicle(vehicle);
        } else {
            System.out.println("No spot available");
        }
    }


    public void unPark(Vehicle vehicle)
    {
        for(int i=0; i<floors.size(); i++)
        {
            Floors floor = floors.get(i);
            List<ParkingSpot> parkingSpots = floor.getParkingSpots();
            for(int j=0; j<parkingSpots.size(); j++)
            {
                if(!parkingSpots.get(j).isAvailable())
                {
                    parkingSpots.get(j).unParkVehcile(vehicle);
                    return;
                }
            }
        }
        System.out.println("No Vehicle is parked in the parking");
    }


}
