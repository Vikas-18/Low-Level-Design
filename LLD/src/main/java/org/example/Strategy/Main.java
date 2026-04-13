package org.example.Strategy;

public class Main {
    public static void main(String[] args) {
        Payment payment = new Payment(new UPI());
        payment.pay();
    }
}
