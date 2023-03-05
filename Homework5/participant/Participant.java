package Homework5.participant;

public abstract class Participant {
    protected double maxDis;
    protected double maxHeight;

    abstract boolean run(double distance);

    abstract boolean jump(double height);
}
