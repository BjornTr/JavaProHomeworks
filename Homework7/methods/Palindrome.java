package Homework7.methods;

import java.util.Scanner;

public class Palindrome {

    public static boolean isPalindrome() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text: ");
        String s = scanner.nextLine();
        StringBuilder reversed = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            reversed.append(s.charAt(i));
        }
        String reversedString = reversed.toString();
        boolean isPalindrome = s.equals(reversedString);
        if (isPalindrome) {
            System.out.println("Is a palindrome.");
        } else {
            System.out.println("Is not a palindrome.");
        }
        return isPalindrome;
    }
}
