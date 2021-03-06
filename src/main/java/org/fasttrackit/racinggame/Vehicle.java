package org.fasttrackit.racinggame;

import org.fasttrackit.racinggame.exception.MaxSpeedExceededException;

public class Vehicle {

    private static int totalVehicleCount = 90;

    private String name;
    private String color;
    private double mileage;
    private double maxSpeed;
    private boolean running;
    private double fuelLevel;
    private double totalTraveledDistance;

    public Vehicle() {
        totalVehicleCount++;
    }

    // method overloading
    public double accelerate(double speed) throws MaxSpeedExceededException {
        return accelerate(speed, 1);
    }

    public double accelerate(double speed, double durationInHours) throws MaxSpeedExceededException {
        if (fuelLevel <= 0) {
            System.out.println("No enough fuel.");
            return 0;
        }

        if (speed > maxSpeed) {
            throw new MaxSpeedExceededException();
        }

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

    // co-variant return type (Vehicle is sub-type of Object)
    protected Vehicle clone() {
        return new Vehicle();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name.trim();
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getMileage() {
        return mileage;
    }

    public void setMileage(double mileage) {
        this.mileage = mileage;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public double getFuelLevel() {
        return fuelLevel;
    }

    public void setFuelLevel(double fuelLevel) {
        this.fuelLevel = fuelLevel;
    }

    public double getTotalTraveledDistance() {
        return totalTraveledDistance;
    }

    public void setTotalTraveledDistance(double totalTraveledDistance) {
        this.totalTraveledDistance = totalTraveledDistance;
    }

    public static int getTotalVehicleCount() {
        return totalVehicleCount;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", mileage=" + mileage +
                ", maxSpeed=" + maxSpeed +
                ", running=" + running +
                ", fuelLevel=" + fuelLevel +
                ", totalTraveledDistance=" + totalTraveledDistance +
                '}';
    }

}
