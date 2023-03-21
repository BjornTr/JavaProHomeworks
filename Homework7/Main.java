package Homework7;


import static Homework7.methods.GuessTheWordGame.playGame;
import static Homework7.methods.Palindrome.isPalindrome;
import static Homework7.methods.StringReverse.stringReverse;
import static Homework7.methods.SymbolOccurrence.findSymbolOccurrence;
import static Homework7.methods.WordPosition.findWordPosition;

public class Main {

    public static void main(String[] args) {

        findSymbolOccurrence();
        findWordPosition();
        stringReverse();
        isPalindrome();
        playGame();
    }
}
