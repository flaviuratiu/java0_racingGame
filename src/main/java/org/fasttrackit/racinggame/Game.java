package org.fasttrackit.racinggame;

import org.fasttrackit.racinggame.exception.MaxSpeedExceededException;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Game {

    private Track[] tracks = new Track[3];
    private List<Vehicle> players = new ArrayList<>();

    public void start() throws Exception {
        initializeTracks();
        initializePlayers();

        Track selectedTrack = getTrackFromUser();

        boolean noWinnerYet = true;
        int playersWithoutFuel = 0;

        while (noWinnerYet && playersWithoutFuel < players.size()) {

            // enhanced for (for-each)
            for (Vehicle vehicle : players) {
                System.out.println("New turn for " + vehicle.getName());
                accelerateWithSpeedFromUser(vehicle);
                System.out.println();

                if (vehicle.getTotalTraveledDistance() >= selectedTrack.getLength()) {
                    System.out.println("Congrats! The winner is: " + vehicle.getName());
                    noWinnerYet = false;
                    break;
                }

                if (vehicle.getFuelLevel() <= 0) {
                    playersWithoutFuel++;
                }
            }
        }

    }

    private void accelerateWithSpeedFromUser(Vehicle vehicle) throws MaxSpeedExceededException {
        double speed = getAccelerationSpeedFromUser();
        try {
            vehicle.accelerate(speed);
        } catch (MaxSpeedExceededException e) {
            System.out.println("Max speed exceeded.");
            accelerateWithSpeedFromUser(vehicle);
        }
    }

    private void initializeTracks() {
        Track track1 = new Track();
        track1.setName("Track1");
        track1.setLength(300);

        Track track2 = new Track();
        track2.setName("Track2");
        track2.setLength(400);

        tracks[0] = track1;
        tracks[1] = track2;

        System.out.println("Available tracks:");
//        System.out.println(tracks[0]);

        for (int i = 0; i < tracks.length; i++) {
//            System.out.println(tracks[i]);
            if (tracks[i] != null) {
                System.out.println(tracks[i].getName() + " - " + tracks[i].getLength());
            }
        }
    }

    private void initializePlayers() throws Exception {
        int playerCount = getPlayerCountFromUser();

        for (int i = 1; i <= playerCount; i++) {
            System.out.println("Adding vehicle for player " + i);

            Vehicle vehicle = new Vehicle();
            vehicle.setName(getVehicleNameFromUser());
            vehicle.setFuelLevel(100);
            vehicle.setMaxSpeed(200);
            vehicle.setMileage(ThreadLocalRandom.current().nextDouble(5, 10));

            System.out.println("Added vehicle " + vehicle.getName() + " with mileage: " + vehicle.getMileage());

            players.add(vehicle);
        }
    }

    private String getVehicleNameFromUser() {
        System.out.println("Please enter vehicle name:");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private int getPlayerCountFromUser() throws Exception {
        System.out.println("Enter number of players...");

        try {
            Scanner scanner = new Scanner(System.in);
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            throw new Exception("Invalid number.");
        } finally {
            System.out.println("Finally always executed");
        }
    }

    private double getAccelerationSpeedFromUser() {
        System.out.println("Enter speed...");

        try {
            Scanner scanner = new Scanner(System.in);
            return scanner.nextDouble();
        } catch (InputMismatchException e) {
            System.out.println("You have entered an invalid decimal number.");
            // recursion
            return getAccelerationSpeedFromUser();
        }
    }

    private Track getTrackFromUser() {
        System.out.println("Enter track number.");
        try {
            Scanner scanner = new Scanner(System.in);
            int trackNumber = scanner.nextInt();
            return tracks[trackNumber - 1];
        } catch (InputMismatchException | ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid track number.");
            return getTrackFromUser();
        }
    }

}

