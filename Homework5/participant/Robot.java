package Homework5.participant;

public class Robot extends Participant {

    private String name;

    public Robot(String name, double maxDis, double maxHeight) {
        this.name = name;
        this.maxDis = maxDis;
        this.maxHeight = maxHeight;
    }

    @Override
    public boolean run(double distance) {
        if (distance < maxDis) {
            System.out.println(name + " has passed the distance ");
            return true;
        } else {
            System.out.println(name);
            return false;
        }
    }

    @Override
    public boolean jump(double height) {
        if (height < maxHeight) {
            System.out.println(name + " has passed the obstacle ");
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String getName() {
        return name;
    }
}
