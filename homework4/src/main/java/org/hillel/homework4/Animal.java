package org.hillel.homework4;

public class Animal {

    private static int count;
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
            System.out.println(this.getClass().getSimpleName() + " named " + this.name + " - successfully ran - " + distance + "m.");
        } else {
            System.out.println(this.getClass().getSimpleName() + " named " + this.name + " - WASTED");
        }
    }

    protected void swim(double distance) {
        if (swim >= distance) {
            System.out.println(this.getClass().getSimpleName() + " named " + this.name + " - successfully swam - " + distance + "m.");
        } else {
            System.out.println(this.getClass().getSimpleName() + " named " + this.name + " - WASTED");
        }
    }

    @Override
    public String toString() {
        return "Animal: " + this.getClass().getSimpleName() +
                ", Name: " + name +
                ", Can run " + run + "m. " +
                ", Can swim " + swim + "m. \n";
    }
}
