package Homework4;

public class Animal {

    private static int count;
    protected String type;
    protected String breed;
    protected String name;
    protected double run;
    protected double swim;

    public Animal() {
        count++;
    }

    public static int getCount() {
        return count;
    }

    protected void run(double distance) {
        if (run >= distance) {
            System.out.println(this.type + " named " + this.name + " - successfully ran - " + distance + "m.");
        } else {
            System.out.println(this.type + " named " + this.name + " - WASTED");
        }
    }

    protected void swim(double distance) {
        if (swim >= distance) {
            System.out.println(this.type + " named " + this.name + " - successfully swam - " + distance + "m.");
        } else {
            System.out.println(this.type + " named " + this.name + " - WASTED");
        }
    }

    @Override
    public String toString() {
        return "Animal: " + type +
                ", Breed: " + breed +
                ", Name: " + name +
                ", Can run " + run + "m. " +
                ", Can swim " + swim + "m. \n";
    }
}
