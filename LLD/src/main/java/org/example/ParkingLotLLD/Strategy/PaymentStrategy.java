package org.example.ParkingLotLLD.Strategy;

import org.example.ParkingLotLLD.Ticket;

public interface PaymentStrategy {
    void pay(double amount, Ticket ticket);
}
