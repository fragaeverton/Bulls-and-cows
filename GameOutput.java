package bullscows;

import java.util.Arrays;
import java.util.List;

public class GameOutput {
    public static final List<Character> digitsImu = Arrays.asList('0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z');

    protected static void lengthLevelMessage() {
        System.out.println("Input the length of the secret code:");
    }

    protected static void rangeLevelMessage() {
        System.out.println("Input the number of possible symbols in the code:");
    }

    protected static void wrongInput(int length, int range) {
        System.out.printf("Error: it's not possible to generate a code with a length of %d with %d unique symbols.", length, range);
    }

    protected static void tipMessage(int length, int range) {
        StringBuilder stars = new StringBuilder();
        stars.append("*".repeat(Math.max(0, length)));
        String message;
        if (range < 11) {
            message = "The secret is prepared: " + stars + "(0-9).";
        } else {
            message = "The secret is prepared: " + stars + "(0-9, a-" + digitsImu.get(range - 1) + ").";
        }
        System.out.println(message);
    }

    protected static void outOfLimitMessage(int length) {
        System.out.printf("Error: can't generate a secret number with a length of %d because there aren't enough unique digits.\n", length);
    }
    protected static void outOfRangeMessage() {
        System.out.print("Error: maximum number of possible symbols in the code is 36 (0-9, a-z).\n");
    }

    protected static void startMessage() {
        System.out.println("Okay, let's start a game!");
    }

    protected static void playerTurnMessage(int turn) {
        System.out.printf("Turn %d:\n", turn);
    }

    protected static void winningMessage(int bull) {
        System.out.printf("Grade %d bulls.\nCongratulations! You guessed the secret code.", bull);
    }

    protected static void noneMessage() {
        System.out.println("Grade: None");

    }
}
