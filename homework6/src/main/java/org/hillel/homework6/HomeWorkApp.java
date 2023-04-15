package org.hillel.homework6;


import org.hillel.homework6.tools.Validator;

public class HomeWorkApp {
    public static void main(String[] args) {
        Validator validator = new Validator();

        taskHeader(1);
        printThreeWords();

        taskHeader(2);
        checkSumSign(validator);

        taskHeader(3);
        printColor(validator);

        taskHeader(4);
        compareNums(validator);

        taskHeader(5);
        isSumBetween(validator);

        taskHeader(6);
        printNumberSign(validator);

        taskHeader(7);
        isNegative(validator);

        taskHeader(8);
        repeatText(validator);

        taskHeader(9);
        isLeapYear(validator);
    }

    public static void taskHeader(int number) {
        System.out.println("\nTask " + number + ":\n");
    }

    public static void printThreeWords() {

        System.out.println("Orange\nBanana\nApple");
    }

    public static void checkSumSign(Validator validator) {

        System.out.println("Enter two numbers:");
        int a = validator.getInt();
        int b = validator.getInt();

        int sum = a + b;
        if (sum >= 0) {
            System.out.println("Sum is positive");
        } else {
            System.out.println("Sum is negative");
        }
    }

    public static void printColor(Validator validator) {

        System.out.println("Enter a number:");
        int value = validator.getInt();

        switch (value >= 0 ? (value >= 100 ? 2 : 1) : 0) {
            case 0 -> System.out.println("Red");
            case 1 -> System.out.println("Yellow");
            case 2 -> System.out.println("Green");
        }
    }

    public static void compareNums(Validator validator) {

        System.out.println("Enter two numbers to compare:");
        int a = validator.getInt();
        int b = validator.getInt();

        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }

    public static void isSumBetween(Validator validator) {

        System.out.print("Enter the first number: ");
        double a = validator.getDouble();

        System.out.print("Enter the second number: ");
        double b = validator.getDouble();

        double sum = a + b;
        boolean isBetween10And20 = sum >= 10.0 && sum <= 20.0;

        System.out.println("The sum is between 10 and 20 - " + isBetween10And20);
    }

    public static void printNumberSign(Validator validator) {

        System.out.println("Enter a number: ");
        int number = validator.getInt();

        if (number >= 0) {
            System.out.println("You entered a positive number.");
        } else {
            System.out.println("You entered a negative number.");
        }
    }

    public static void isNegative(Validator validator) {

        System.out.println("Enter a number: ");
        int number = validator.getInt();
        boolean isNegative = number <= 0;
        System.out.println("The number is negative - " + isNegative);
    }

    public static void repeatText(Validator validator) {

        System.out.println("Enter text: ");
        String ranText = validator.getString();

        System.out.println("Enter a number: ");
        int count = validator.getInt();

        for (int i = 0; i < count; i++) {
            System.out.println(ranText);
        }
    }

    public static void isLeapYear(Validator validator) {

        System.out.println("Please enter year: ");
        int year = validator.getInt();
        boolean isLeap = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
        System.out.println(isLeap ? year + " is a leap year" : year + " is not a leap year");
    }
}
