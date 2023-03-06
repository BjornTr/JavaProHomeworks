package Homework5.obstacles;

import Homework5.participant.Participant;

public class Wall implements Obstacle {
    private double height;

    public Wall(double height) {
        this.height = height;
    }

    @Override
    public boolean overcome(Participant participant) {
        return participant.jump(height);
    }
}
