package org.example.Strategy;

public class UPI implements PaymentStrategy{
    @Override
    public void pay() {
        System.out.println("UPI payment initiated");
    }
}
