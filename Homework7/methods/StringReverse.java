package Homework7.methods;

import java.util.Scanner;

public class StringReverse {

    public static String stringReverse() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text: ");
        String s = scanner.nextLine();
        StringBuilder reversed = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            reversed.append(s.charAt(i));
        }
        String result = reversed.toString();
        System.out.println("The reversed text is: " + result);
        return result;
    }
}
