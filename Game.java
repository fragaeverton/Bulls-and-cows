package bullscows;

import java.util.Arrays;

public class Game {
    private final int[] code;
    private GameState state;
    int counter;
    public static String sCode;

    public Game(String secretCode) {
        this.code = getCollection(secretCode);
        sCode = secretCode;
        startGame();
    }

    private void startGame() {
        state = GameState.PLAYING;
        counter++;
    }

    public boolean isWorking() {
        return state != GameState.OVER;
    }

    public void execute(String guess) {
        switch (state) {
            case OVER:
                System.out.println("over");
                break;
            case PLAYING:
                checkGame(guess);
                break;
        }
    }

    public void checkGame(String givenGuess) {
        int cow = 0;
        int bull = 0;
        int[] guess = getCollection(givenGuess);
        for (int i = 0; i < code.length; i++) {
            for (int k : guess) {
                if (code[i] == k) {
                    cow++;
                }
            }
            if (code[i] == guess[i]) {
                bull++;
                cow--;
            }
        }
        if (bull == 4) {
            System.out.printf("Grade 4 bulls.\nCongrats! The secret code is %s.", givenGuess);
            state = GameState.OVER;
        } else if (bull == 0 && cow == 0) {
            System.out.println("Grade: None. The secret code is " + sCode + ".");
            startGame();
        } else {
            String msgBull;
            if (bull == 0) {
                msgBull = "";
            } else {
                msgBull = bull + " bull(s)";
            }
            String msgCow;
            if (cow == 0) {
                msgCow = "";
            } else {
                msgCow = cow + " cow(s)";
            }
            if (!msgBull.isEmpty() && !msgCow.isEmpty()) {
                System.out.println("Grade: " + msgBull + " and " + msgCow + ". The secret code is " + sCode + ".");
            } else {
                System.out.println("Grade: " + msgBull + msgCow + ". The secret code is " + sCode + ".");
            }
            state = GameState.OVER;
            //startGame();
        }

    }

    public static int[] getCollection(String digit){
        int first = Character.getNumericValue(digit.charAt(0));
        int second = Character.getNumericValue(digit.charAt(1));
        int third = Character.getNumericValue(digit.charAt(2));
        int forth = Character.getNumericValue(digit.charAt(3));
        return new int[]{first, second, third, forth};
    }
}
