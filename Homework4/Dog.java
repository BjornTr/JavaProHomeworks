package Homework4;

public class Dog extends AnimalWithBreed {

    private static int count;

    public Dog(String breed, String name, double maxRunDistance, double maxSwimDistance) {
        super(breed);
        this.name = name;
        this.run = maxRunDistance;
        this.swim = maxSwimDistance;
        count++;
    }

    public static int getCount() {
        return count;
    }
}
