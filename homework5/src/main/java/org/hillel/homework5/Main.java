package org.hillel.homework5;

import org.hillel.homework5.obstacles.Obstacle;
import org.hillel.homework5.obstacles.Treadmill;
import org.hillel.homework5.obstacles.Wall;
import org.hillel.homework5.participant.Cat;
import org.hillel.homework5.participant.Human;
import org.hillel.homework5.participant.Participant;
import org.hillel.homework5.participant.Robot;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Participant> participants = new ArrayList<>();
        participants.add(new Cat("Murzik", 200, 6));
        participants.add(new Cat("Barsik", 150, 4));
        participants.add(new Human("Oleg", 500, 10));
        participants.add(new Human("Johny", 600, 11));
        participants.add(new Robot("T-1000", 50000, 25));
        participants.add(new Robot("Predator", 20000, 40));

        List<Obstacle> obstacles = new ArrayList<>();
        obstacles.add(new Wall(9));
        obstacles.add(new Treadmill(150));
        obstacles.add(new Wall(20));
        obstacles.add(new Treadmill(5000));

        for (Participant participant : participants) {
            for (Obstacle obstacle : obstacles) {
                boolean success = obstacle.overcome(participant);
                if (!success) {
                    System.out.println(participant.getName() + " failed to overcome a " + obstacle.getClass().getSimpleName());
                    break;
                }
            }
        }

    }


}
