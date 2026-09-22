package org.example.ParkingLotLLD.Strategy;

import org.example.ParkingLotLLD.Ticket;

import java.time.Duration;
import java.time.LocalDateTime;

// Flat rate per hour regardless of vehicle type or floor
public class HourlyPricing implements PricingStrategy {

    private final double ratePerHour;

    public HourlyPricing(double ratePerHour) {
        this.ratePerHour = ratePerHour;
    }

    @Override
    public double calculatePrice(Ticket ticket) {
        long minutes = Duration.between(ticket.getEntryTime(), LocalDateTime.now()).toMinutes();
        // Minimum 1 hour billing
        double hours = Math.max(1, Math.ceil(minutes / 60.0));
        return hours * ratePerHour;
    }
}
