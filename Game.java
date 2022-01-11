package bullscows;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static bullscows.GameOutput.*;

public class Game {
    private final List<Integer> code;
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
        playerTurnMessage(counter);
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
        int[] bullsCows = getBullsCows(givenGuess);
        int bull = bullsCows[0];
        int cow = bullsCows[1];
        if (bull == sCode.length()) {
            winningMessage(bull);
            state = GameState.OVER;
        } else if (bull == 0 && cow == 0) {
            noneMessage();
            startGame();
        }else {
            String msgBull = (bull == 0) ? "" : ((bull == 1) ? 1 + " bull" : bull + " bulls");
            String msgCow = (cow == 0) ? "" : ((cow == 1) ? 1 + " cow" : cow + " cows");
            String full = (!msgBull.isEmpty() && !msgCow.isEmpty()) ? "Grade: " + msgBull + " and " + msgCow : "Grade: " + msgBull + msgCow;
            System.out.println(full);
            startGame();
        }

    }

    private int[] getBullsCows(String givenGuess) {
        int cow = 0;
        int bull = 0;
        List<Integer> guess = getCollection(givenGuess);
        for (int i = 0; i < code.size(); i++) {
            for (int k : guess) {
                if (code.get(i) == k) {
                    cow++;
                }
            }
            if (Objects.equals(code.get(i), guess.get(i))) {
                bull++;
                cow--;
            }
        }
        return new int[]{bull, cow};
    }

    public static List<Integer> getCollection(String digit){
        List<Integer> digits = new ArrayList<>();
        for (int i = 0; i < digit.length(); i++) {
            digits.add(Character.getNumericValue(digit.charAt(i)));
        }
        return digits;
    }
}
