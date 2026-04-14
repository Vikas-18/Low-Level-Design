package org.example.Factory;

public class Main {
    public static void main(String[] args) {

        Vehicle vehicle = VehicleFactory.getVehicle("Car");
        vehicle.wheels();
    }
}
