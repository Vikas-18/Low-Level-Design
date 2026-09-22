package org.example.ParkingLotLLD.Strategy;

import org.example.ParkingLotLLD.Ticket;

public interface PricingStrategy {
    double calculatePrice(Ticket ticket);
}
