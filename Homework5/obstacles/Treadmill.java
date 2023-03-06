package Homework5.obstacles;

import Homework5.participant.Participant;

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
