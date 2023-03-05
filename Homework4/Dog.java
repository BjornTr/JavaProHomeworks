package Homework4;

public class Dog extends Animal {

    private static int count;

    public Dog(String type, String breed, String name, double swim, double run) {
        this.type = type;
        this.breed = breed;
        this.name = name;
        this.swim = swim;
        this.run = run;
        count++;
    }

    public static int getCount() {
        return count;
    }
}
