package org.hillel.homework4;

public class Horse extends Animal {

    private static int count;

    public Horse(String name, double maxRunDistance, double maxSwimDistance) {
        this.name = name;
        this.run = maxRunDistance;
        this.swim = maxSwimDistance;
        count++;
    }

    public static int getCount() {
        return count;
    }

    @Override
    protected void swim(double distance) {
        System.out.println("Horses can't swim that far.");
    }
}
