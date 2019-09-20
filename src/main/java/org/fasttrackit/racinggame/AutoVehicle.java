package org.fasttrackit.racinggame;

public class AutoVehicle extends Vehicle {

    // "has-a" relationship
    Engine engine;

    public AutoVehicle(Engine engine) {
        this.engine = engine;
    }

}
