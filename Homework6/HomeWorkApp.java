package Homework6;

import java.util.Locale;
import java.util.Scanner;

public class HomeWorkApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

//        printThreeWords();
//        checkSumSign(scanner);
//        printColor(scanner);
//        compareNums(scanner);
//        isSumBetween(scanner);
//        printNumberSign(scanner);
//        isNegative(scanner);
//        printString(scanner);
        isLeapYear(scanner);

    }

    public static void printThreeWords() {
        System.out.println("Task 1");
        System.out.println("Orange\nBanana\nApple");
    }

    public static void checkSumSign(Scanner scanner) {
        System.out.println("Task 2");
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
        System.out.println("Task 3");
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

    public static void compareNums(Scanner scanner) {
        System.out.println("Task 4");
        System.out.println("Enter two numbers to compare:");
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }

    public static void isSumBetween(Scanner scanner) {
        System.out.println("Task 5");
        System.out.print("Enter the first number: ");
        double a = scanner.nextDouble();

        System.out.print("Enter the second number: ");
        double b = scanner.nextDouble();

        double sum = a + b;
        boolean isBetween10And20 = sum >= 10.0 && sum <= 20.0;

        System.out.print("The sum is between 10 and 20 - " + isBetween10And20);
    }

    public static void printNumberSign(Scanner scanner) {
        System.out.println("Task 6");
        System.out.println("Enter a number: ");
        int number = scanner.nextInt();

        if (number >= 0) {
            System.out.println("You entered a positive number.");
        } else {
            System.out.println("You entered a negative number.");
        }
    }

    public static void isNegative(Scanner scanner) {
        System.out.println("Task 7");
        System.out.println("Enter a number: ");
        int number = scanner.nextInt();
        boolean isNegative = number <= 0;
        System.out.print("The number is negative - " + isNegative);
    }

    public static void printString(Scanner scanner) {
        System.out.println("Task 8");
        System.out.println("Enter the text: ");
        String ranText = scanner.nextLine();
        System.out.println("Enter the number: ");
        int count = scanner.nextInt();

        for (int i = 0; i < count; i++) {
            System.out.println(ranText);
        }
    }

    public static boolean isLeapYear(Scanner scanner) {
        System.out.println("Task 9");
        System.out.println("Please enter the year: ");
        int year = scanner.nextInt();
        boolean isLeap = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
        System.out.println(isLeap ? year + " is a leap year" : year + " is not a leap year");
        return isLeap;
    }
}
