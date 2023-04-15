package org.hillel.homework6.tools;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Validator {
    private final Scanner scanner;

    public Validator() {
        this.scanner = new Scanner(System.in).useLocale(Locale.US);
    }

    public int getInt() {
        int input;
        while (true) {
            try {
                input = scanner.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.nextLine();
            }
        }
        return input;
    }

    public String getString() {
        String input;
        scanner.nextLine();
        do {
            input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("Invalid input. Please enter a non-empty string.");
            }
        } while (input.isEmpty());
        return input;
    }

    public double getDouble() {
        double input;
        while (true) {
            try {
                input = scanner.nextDouble();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid double.");
                scanner.nextLine();
            }
        }
        return input;
    }
}