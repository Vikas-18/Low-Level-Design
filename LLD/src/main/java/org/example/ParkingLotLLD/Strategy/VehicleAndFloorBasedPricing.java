package org.example.ParkingLotLLD.Strategy;

import org.example.ParkingLotLLD.Ticket;
import org.example.ParkingLotLLD.VehicleType;

import java.time.Duration;
import java.time.LocalDateTime;

// Dynamic pricing based on vehicle type + floor number
// Ground floor (floor 1) costs more, bikes cost less than cars/trucks
public class VehicleAndFloorBasedPricing implements PricingStrategy {

    @Override
    public double calculatePrice(Ticket ticket) {
        long minutes = Duration.between(ticket.getEntryTime(), LocalDateTime.now()).toMinutes();
        double hours = Math.max(1, Math.ceil(minutes / 60.0));

        double baseRate = getBaseRateForVehicle(ticket.getVehicle().getVehicleType());
        double floorMultiplier = getFloorMultiplier(ticket.getFloorNumber());

        return hours * baseRate * floorMultiplier;
    }

    private double getBaseRateForVehicle(VehicleType vehicleType) {
        return switch (vehicleType) {
            case BIKE -> 20.0;
            case CAR -> 50.0;
            case TRUCK -> 100.0;
            default -> 50.0;
        };
    }

    // Ground floor is premium (higher multiplier), upper floors are cheaper
    private double getFloorMultiplier(int floorNumber) {
        switch (floorNumber) {
            case 1:  return 1.5;
            case 2:  return 1.2;
            default: return 1.0;
        }
    }
}
