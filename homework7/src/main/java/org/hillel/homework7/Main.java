package org.hillel.homework7;

import static org.hillel.homework7.methods.GuessTheWordGame.playGame;
import static org.hillel.homework7.methods.Palindrome.isPalindrome;
import static org.hillel.homework7.methods.StringReverse.stringReverse;
import static org.hillel.homework7.methods.SymbolOccurrence.findSymbolOccurrence;
import static org.hillel.homework7.methods.WordPosition.findWordPosition;


public class Main {

    public static void main(String[] args) {

        findSymbolOccurrence();
        findWordPosition();
        stringReverse();
        isPalindrome();
        playGame();
    }
}
