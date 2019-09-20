package org.fasttrackit.racinggame;

import org.fasttrackit.racinggame.Car;

public class App {

    public static void main(String[] args) {
        Engine engine = new Engine();
        engine.manufacturer = "BavariaMotors";
        engine.cubicCentimeters = 3000;

        Car car = new Car(engine);
        car.setName("BMW");
        car.setColor("gray");
        car.doorCount = 4;
        car.setMaxSpeed(240);
        car.setMileage(10.5);
        car.setRunning(true);

        double speed = 100;


        double distance = car.accelerate(60, 1);



        System.out.println(car);


        System.out.println("Engine details: " +
                car.engine.manufacturer);

        engine.manufacturer = "VW";

        System.out.println("Engine details2: " +
                car.engine.manufacturer);

        car.engine.manufacturer = "Renault";

        System.out.println("Engine details3: " +
                car.engine.manufacturer);

        System.out.println("Engine: " + engine.manufacturer);


        System.out.println("Car1: " + car.getName());

        Car car2 = new Car(new Engine());
        car2.setName("Kia");

        System.out.println("Car2: " + car2.getName());

        car2.setName("Dacia");
        System.out.println("Car2: " + car2.getName());

        System.out.println(car2.getColor());
        System.out.println(car2.doorCount);
        System.out.println(car2.isRunning());


        car2 = car;

        System.out.println("Car 2 changed: " + car2.getName());

    }
}