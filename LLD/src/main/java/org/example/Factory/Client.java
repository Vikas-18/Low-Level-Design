package org.example.Factory;

public class Client {
    public static void main(String[] args) {
        Vehicle vehicle = VehicleFactory.getVehicle("Bike");
        assert vehicle != null;
        vehicle.wheels();
    }
}
