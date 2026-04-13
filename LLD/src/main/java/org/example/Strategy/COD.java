package org.example.Strategy;

public class COD implements PaymentStrategy{
    @Override
    public void pay() {
        System.out.print("COD Initiated");
    }
}
