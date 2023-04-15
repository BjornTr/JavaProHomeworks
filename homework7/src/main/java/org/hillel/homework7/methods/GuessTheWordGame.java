package org.hillel.homework7.methods;

import java.util.Random;
import java.util.Scanner;

public class GuessTheWordGame {

    private static final String[] WORDS = {
            "apple", "orange", "lemon", "banana", "apricot",
            "avocado", "broccoli", "carrot", "cherry", "garlic",
            "grape", "melon", "leak", "kiwi", "mango",
            "mushroom", "nut", "olive", "pea", "peanut",
            "pear", "pepper", "pineapple", "pumpkin", "potato"};

    public static void playGame() {
        System.out.println("Task 5 - <Guess The Word> game");
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        String word = WORDS[random.nextInt(WORDS.length)];
        String guessedWord = "#".repeat(word.length());
        System.out.println("Guess the word: " + guessedWord);
        while (!guessedWord.equals(word)) {
            String guess = scanner.nextLine().toLowerCase();
            if (guess.equals(word)) {
                System.out.println("Congratulations, you guessed the word!");
                break;
            }
            System.out.print("Wrong! Try again. ");
            StringBuilder sb = new StringBuilder(guessedWord);
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == guess.charAt(i)) {
                    sb.setCharAt(i, guess.charAt(i));
                }
            }
            guessedWord = sb.toString();
            System.out.println("Guess the word: " + guessedWord);

        }
    }
}
