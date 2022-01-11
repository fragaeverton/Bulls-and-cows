package bullscows;


import java.util.*;

import static bullscows.GameOutput.*;

public class Main {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);
        lengthLevelMessage();
        int length = scanner.nextInt();
        rangeLevelMessage();
        int range = scanner.nextInt();
        tipMessage(length, range);

        if (length > 10) {
            outOfLimitMessage(length);
        } else {
            startMessage();
            startGame(randomGenerator(length, range));
        }
    }

    private static void startGame(String secretCode) {
        Scanner scanner = new Scanner(System.in);
        Game game = new Game(secretCode);
        while (game.isWorking()) {
            game.execute(scanner.nextLine());
        }
    }

    private static String randomGenerator(int number, int range) {
        List<Character> digits = digitsImu.subList(0, range);
        StringBuilder sb = new StringBuilder();
        while (digits.get(0) == '0') {
            Collections.shuffle(digits);
        }
        for (Character character : digits) {
            sb.append(character);
        }
        return sb.substring(0, number);
    }
}
