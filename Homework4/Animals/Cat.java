package Homework4.Animals;

public class Cat extends Animal {

    private static int count;

    public Cat(String type, String breed, String name, int swim, int run) {
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
