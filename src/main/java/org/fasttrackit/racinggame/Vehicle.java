package org.fasttrackit.racinggame;

public class Vehicle {

    String name;
    String color;
    double mileage;
    double maxSpeed;
    boolean running;
    double fuelLevel;
    double totalTraveledDistance;

    public double accelerate(double speed, double durationInHours) {
        System.out.println(name + " is accelerating with " +
                speed + " for " + durationInHours + " h.");

        double traveledDistance = speed * durationInHours;

        System.out.println("Traveled distance: " + traveledDistance);

        double usedFuel = traveledDistance * mileage / 100;

        System.out.println("Used fuel: " + usedFuel);

        fuelLevel = fuelLevel - usedFuel;
//        same result as the statement above
//        fuelLevel -= usedFuel;

        totalTraveledDistance = totalTraveledDistance + traveledDistance;
        //        same result as the statement above
//        totalTraveledDistance += traveledDistance;

        System.out.println("Remaining fuel: " + fuelLevel);
        System.out.println("Total traveled distance: " + totalTraveledDistance);

        return traveledDistance;
    }


}
