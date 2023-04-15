package org.hillel.homework4;

public class AnimalWithBreed extends Animal {

    private final String breed;

    public AnimalWithBreed(String breed) {
        this.breed = breed;
    }

    @Override
    public String toString() {
        return "Animal: " + getClass().getSimpleName() +
                ", Breed: " + breed +
                ", Name: " + name +
                ", Can run " + run + "m. " +
                ", Can swim " + swim + "m. \n";
    }

}
