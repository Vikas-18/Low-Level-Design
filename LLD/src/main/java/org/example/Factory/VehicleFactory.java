package org.example.Factory;

public class VehicleFactory {

    public static Vehicle getVehicle(String type)
    {
        if(type.trim().equalsIgnoreCase("Bike"))
        {
            return new Bike();
        }
        else if(type.trim().equalsIgnoreCase("Car"))
        {
            return new Car();
        }
        return null;
    }

}
