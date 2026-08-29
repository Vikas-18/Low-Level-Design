package org.example.ParkingLotLLD.Strategy;

import org.example.ParkingLotLLD.Ticket;

public class UPI implements PaymentStrategy {
    @Override
    public void pay(double amount, Ticket ticket) {
        System.out.println("Paying Rs." + amount + " for ticket " + ticket.getTicketId() + " using UPI");
    }
}
