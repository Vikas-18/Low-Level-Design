package org.example.ParkingLotLLD;

import lombok.Getter;
import org.example.ParkingLotLLD.Strategy.PaymentStrategy;
import org.example.ParkingLotLLD.Strategy.PricingStrategy;
import org.example.ParkingLotLLD.Strategy.SpotFindingStrategy;

import java.util.List;

@Getter
public class ParkingLot {
    List<Floors> floors;
    SpotFindingStrategy spotFindingStrategy;
    PricingStrategy pricingStrategy;

    ParkingLot(List<Floors> floors, SpotFindingStrategy spotFindingStrategy, PricingStrategy pricingStrategy) {
        this.floors = floors;
        this.spotFindingStrategy = spotFindingStrategy;
        this.pricingStrategy = pricingStrategy;
    }

    // Returns a Ticket on successful park, null if no spot available
    public Ticket park(Vehicle vehicle) {
        for (int i = 0; i < floors.size(); i++) {
            Floors floor = floors.get(i);
            ParkingSpot spot = spotFindingStrategy.findSpot(List.of(floor), vehicle);
            if (spot != null) {
                spot.parkVehicle(vehicle);
                Ticket ticket = new Ticket(vehicle, spot, floor.getFloorNumber());
                System.out.println("Ticket generated: " + ticket.getTicketId());
                return ticket;
            }
        }
        System.out.println("No spot available");
        return null;
    }

    // Customer hands in ticket and chooses payment method
    public void unPark(Ticket ticket, PaymentStrategy paymentStrategy) {
        ParkingSpot spot = ticket.getParkingSpot();
        if (spot.isAvailable()) {
            System.out.println("This ticket has already been used for unparking.");
            return;
        }
        double amount = pricingStrategy.calculatePrice(ticket);
        paymentStrategy.pay(amount, ticket);
        spot.unParkVehcile(ticket.getVehicle());
    }
}
