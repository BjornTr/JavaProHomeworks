package org.hillel.homework5.obstacles;

import org.hillel.homework5.participant.Participant;

public class Treadmill implements Obstacle {

    private double distance;

    public Treadmill(double distance) {
        this.distance = distance;
    }

    @Override
    public boolean overcome(Participant participant) {
        return participant.run(distance);
    }
}
