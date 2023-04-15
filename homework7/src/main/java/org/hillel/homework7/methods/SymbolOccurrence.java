package org.hillel.homework7.methods;

import java.util.Scanner;

public class SymbolOccurrence {

    public static void findSymbolOccurrence() {
        System.out.println("Task 1 - findSymbolOccurrence method");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text: ");
        String s = scanner.nextLine();
        System.out.print("Enter a character: ");
        char symbol = scanner.nextLine().charAt(0);
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == symbol) {
                count++;
            }
        }
        System.out.println("The character '" + symbol + "' appears " + count + " times in the text.");
    }
}
