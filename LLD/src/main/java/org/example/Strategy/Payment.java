package org.example.Strategy;

public class Payment {
    PaymentStrategy paymentStrategy;

    Payment(PaymentStrategy paymentStrategy)
    {
        this.paymentStrategy = paymentStrategy;
    }

    public void pay()
    {
        paymentStrategy.pay();
    }
}
