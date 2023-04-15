package org.hillel.homework10;

public class MyMathLib {

    public static double add(double num1, double num2) {
        return num1 + num2;
    }

    public static double subtract(double num1, double num2) {
        return num1 - num2;
    }

    public static double multiply(double num1, double num2) {
        return num1 * num2;
    }

    public static double divide(double num1, double num2) {
        return num1 / num2;
    }

    public static double squareRoot(double num) {
        return Math.sqrt(num);
    }

    public static double power(double base, double exponent) {
        return Math.pow(base, exponent);
    }

    public static double absolute(double num) {
        return Math.abs(num);
    }
}
