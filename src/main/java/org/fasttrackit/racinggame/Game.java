package org.fasttrackit.racinggame;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private Track[] tracks = new Track[3];
    private List<Vehicle> players = new ArrayList<>();

    public void start() {
        initializeTracks();
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


}

