package Homework7.methods;

import java.util.Scanner;

public class WordPosition {

    public static int findWordPosition() {
        System.out.println("Task 2 - findWordPosition method");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the source string: ");
        String source = scanner.nextLine();
        System.out.print("Enter the target string: ");
        String target = scanner.nextLine();
        int index = source.indexOf(target);
        if (index != -1) {
            System.out.println("The target string is found at index " + index);
        } else {
            System.out.println("The target string is not found in the source string.");
        }
        return index;
    }
}
