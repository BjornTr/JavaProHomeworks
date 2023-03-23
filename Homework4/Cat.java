package Homework4;

public class Cat extends AnimalWithBreed {

    private static int count;

    public Cat(String breed, String name, double maxRunDistance, double maxSwimDistance) {
        super(breed);
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
        System.out.println("Cats can't swim.");
    }
}
