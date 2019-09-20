package org.fasttrackit.racinggame;

public class AutoVehicle extends Vehicle {

    // "has-a" relationship
    Engine engine;

    public AutoVehicle(Engine engine) {
        this.engine = engine;
    }

    // constructor overloading
    public AutoVehicle() {
        this(new Engine());

        // same effect as calling the other constructor as done above
//        this.engine = new Engine();
    }
}
