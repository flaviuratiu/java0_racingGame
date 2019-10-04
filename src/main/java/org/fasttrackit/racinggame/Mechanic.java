package org.fasttrackit.racinggame;

public class Mechanic {

    public void repair(Vehicle vehicle) {
        System.out.println("Repairing vehicle: " + vehicle.getName());
        vehicle.setFuelLevel(100);
    }
}
