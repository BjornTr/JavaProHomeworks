package Homework6;

import java.util.Scanner;

public class HomeWorkApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        printThreeWords();
        checkSumSign(scanner);
        printColor(scanner);

    }

    public static void printThreeWords() {
        System.out.println("Orange\nBanana\nApple");
    }

    public static void checkSumSign(Scanner scanner) {
        System.out.println("Enter two numbers:");
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        int sum = a + b;
        if (sum >= 0) {
            System.out.println("Sum is positive");
        } else {
            System.out.println("Sum is negative");
        }
    }

    public static void printColor(Scanner scanner) {
        System.out.println("Enter a number:");
        int value = scanner.nextInt();

        if (value <= 0) {
            System.out.println("Red");
        } else if (value >= 0 && value <= 100) {
            System.out.println("Yellow");
        } else if (value >= 100) {
            System.out.println("Green");
        }
    }


}
