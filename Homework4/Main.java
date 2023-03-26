package Homework4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        List<Animal> animals = new ArrayList<>();
        animals.add(new Cat("Breedless", "Murzik", 200.00, 0));
        animals.add(new Cat("British Shorthair", "Barsik", 180.00, 0));
        animals.add(new Dog("Pitbull", "Cerberus", 6666.66, 666.66));
        animals.add(new Dog("Labrador", "Useless meat", 300.00, 200.00));
        animals.add(new Horse("Spirit", 2000.00, 10.00));

        System.out.println(
                "\nGeneral information: " +
                        "\nAnimals total: " + (Animal.getCount()) +
                        "\nCats total: " + (Cat.getCount()) +
                        "\nDogs total: " + (Dog.getCount()) +
                        "\nHorses total: " + (Horse.getCount()) + "\n");

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
