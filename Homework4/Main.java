package Homework4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        List<Animal> animals = new ArrayList<>();
        animals.add(new Cat("Cat", "Breedless", "Murzik", 0, 200.00));
        animals.add(new Cat("Cat", "Breedless", "Barsik", 0, 200.00));
        animals.add(new Dog("Dog", "Pitbull", "Cerberus", 666.66, 6666.66));
        animals.add(new Dog("Dog", "Labrador", "Useless meat", 200.00, 300.00));

        System.out.println(
                "\nGeneral information: " +
                        "\nAnimals total: " + (Animal.getCount()) +
                        "\nCats total: " + (Cat.getCount()) +
                        "\nDogs total: " + (Dog.getCount()) + "\n");

        animals.forEach(animal -> System.out.println(animal.toString()));

        Scanner scanner = new Scanner(System.in);

        for (Animal animal : animals) {
            System.out.println("Please enter the distance to run: ");
            animal.run(scanner.nextDouble());
            System.out.println("Please enter the distance to swim: ");
            animal.swim(scanner.nextDouble());
        }
    }
}
