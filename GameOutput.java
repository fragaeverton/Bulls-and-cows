package bullscows;

public class GameOutput {
    protected static void chooseGameLevelMessage() {
        System.out.println("Please, enter the secret code's length:");
    }

    protected static void outOfLimitMessage(int length) {
        System.out.printf("Error: can't generate a secret number with a length of %d because there aren't enough unique digits.\n", length);
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
