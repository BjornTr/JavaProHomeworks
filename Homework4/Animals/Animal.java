package Homework4.Animals;

public class Animal {

    private static int count;
    protected String type;
    protected String breed;
    protected String name;
    protected int run;
    protected int swim;

    public Animal() {
        count++;
    }

    public static int getCount() {
        return count;
    }

    protected void run(int distance) {
        if (run >= distance) {
            System.out.println(this.type + " named " + this.name + " - ran - " + distance + "m.");
        } else {
            System.out.println(this.type + " named " + this.name + "WASTED");
        }
    }

    protected void swim(int distance) {
        if (run >= distance) {
            System.out.println(this.type + " named " + this.name + " - swam - " + distance + "m.");
        } else {
            System.out.println(this.type + " named " + this.name + "WASTED");
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
