package org.fasttrackit.racinggame;

import org.fasttrackit.racinggame.Car;

public class App {

    public static void main(String[] args) {
        Car car = new Car();
        car.name = "BMW";
        car.color = "gray";
        car.doorCount = 4;
        car.maxSpeed = 240;
        car.mileage = 10.5;
        car.running = true;

        double speed = 100;


        double distance = car.accelerate(60, 1);



        System.out.println(car);

        Engine engine = new Engine();
        engine.manufacturer = "BavariaMotors";
        engine.cubicCentimeters = 3000;

        car.engine = engine;

        System.out.println("Engine details: " +
                car.engine.manufacturer);

        engine.manufacturer = "VW";

        System.out.println("Engine details2: " +
                car.engine.manufacturer);

        car.engine.manufacturer = "Renault";

        System.out.println("Engine details3: " +
                car.engine.manufacturer);

        System.out.println("Engine: " + engine.manufacturer);


        System.out.println("Car1: " + car.name);

        Car car2 = new Car();
        car2.name = "Kia";

        System.out.println("Car2: " + car2.name);

        car2.name = "Dacia";
        System.out.println("Car2: " + car2.name);

        System.out.println(car2.color);
        System.out.println(car2.doorCount);
        System.out.println(car2.running);


        car2 = car;

        System.out.println("Car 2 changed: " + car2.name);

    }
}