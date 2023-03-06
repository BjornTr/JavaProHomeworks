package Homework5.participant;

public abstract class Participant {
    protected double maxDis;
    protected double maxHeight;

    public boolean run(double distance) {
        if (distance < maxDis) {
            System.out.println("Participant has passed the distance ");
            return true;
        } else {
            System.out.println("Participant has failed");
            return false;
        }
    }

    public boolean jump(double height) {
        if (height < maxHeight) {
            System.out.println("Participant has passed the distance ");
            return true;
        } else {
            System.out.println("Participant has failed");
            return false;
        }
    }

    public String getName() {
        return null;
    }
}
