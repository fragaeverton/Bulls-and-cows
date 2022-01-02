package bullscows;

public class Game {
    private final int[] code;
    private GameState state;
    int counter;

    public Game(int secretCode) {
        this.code = getCollection(secretCode);
        startGame();
    }

    private void startGame() {
        state = GameState.PLAYING;
        counter++;
        System.out.printf("\nTurn %d. Answer: \n", counter);
    }

    public boolean isWorking() {
        return state != GameState.OVER;
    }

    public void execute(int guess) {
        switch (state) {
            case OVER:
                System.out.println("over");
                break;
            case PLAYING:
                checkGame(guess);
                break;
        }
    }
    public void checkGame(int givenGuess) {
        int cow = 0;
        int bull = 0;
        int[] guess = getCollection(givenGuess);
        for (int i = 0; i < code.length; i++) {
            for (int j = 0; j< guess.length; j++) {
                if (code[i] == guess[j]) {
                    cow++;
                }
            }
            if (code[i] == guess[i]) {
                bull++;
                cow--;
            }
        }
        if (bull == 4) {
            System.out.printf("Grade 4 bulls.\nCongrats! The secret code is %d.", givenGuess);
            state = GameState.OVER;
        } else if (bull == 0 && cow == 0) {
            System.out.println("Grade: None");
            startGame();
        }else {
            String msgBull;
            if (bull == 0) {
                msgBull = "";
            } else if (bull == 1) {
                msgBull = 1 + " bull";
            } else {
                msgBull = bull + " bulls";
            }
            String msgCow;
            if (cow == 0) {
                msgCow = "";
            } else if (cow == 1) {
                msgCow = 1 + " cow";
            } else {
                msgCow = cow + " cows";
            }
            if (!msgBull.isEmpty() && !msgCow.isEmpty()) {
                System.out.println("Grade: " + msgBull + " and " + msgCow + ".");
            } else {
                System.out.println("Grade: " + msgBull + msgCow + ".");
            }
            startGame();
        }

    }
    public static int[] getCollection(int digit){
        int first = digit / 1000;
        int second = (digit - (first * 1000)) / 100;
        int third = (digit - (first * 1000 + second * 100)) / 10;
        int forth = digit - (first * 1000 + second * 100 + third * 10);
        return new int[]{first, second, third, forth};
    }
}
