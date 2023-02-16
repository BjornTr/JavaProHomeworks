package Homework3.Employee;

import java.util.Scanner;


public class Validator {

    public static String validateNameInput(Scanner scanner) {
        String name = scanner.nextLine().trim();
        while (name.isEmpty()) {
            System.out.print("Empty! Enter the name: ");
            name = scanner.nextLine().trim();
        }
        return name;
    }

    public static String validateEmailInput(Scanner scanner) {
        String email = scanner.nextLine().trim();
        while (email.isEmpty()) {
            System.out.print("Unacceptable email!\n" +
                    "Please enter a correct email: ");
            email = scanner.nextLine().trim();
        }
        return email;
    }

    public static String validatePhoneInput(Scanner scanner) {
        String phone = scanner.nextLine().trim();
        while (phone.isEmpty()) {
            System.out.print("Empty! Enter the phone: ");
            phone = scanner.nextLine().trim();
        }
        return phone;
    }

    public static String validatePositionInput(Scanner scanner) {
        String position = scanner.nextLine().trim();
        while (position.isEmpty()) {
            System.out.print("Empty! Enter the position: ");
            position = scanner.nextLine().trim();
        }
        return position;
    }

    public static int validateAgeInput(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            String age = scanner.nextLine().trim();
            System.out.printf("\"%s\" - NOT a number!%n" +
                    "Please enter the age: ", age);
        }
        int age = scanner.nextInt();
        while (age <= 0) {
            System.out.println("Wrong input! Please enter the age: ");
            while (!scanner.hasNextInt()) {
                String str = scanner.next().trim();
                System.out.printf("\"%s\" - NOT a number!%n" +
                        "Please enter the age: ", str);
            }
            age = scanner.nextInt();
        }
        return age;
    }
}
