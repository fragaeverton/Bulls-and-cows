package bullscows;


import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

import static bullscows.GameOutput.*;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        chooseGameLevelMessage();

        int length = scanner.nextInt();
        String secretCode = "";
        if (length > 10) {
            outOfLimitMessage(length);
        } else {
            startMessage();
            while (secretCode.length() < length) {
                secretCode = pseudoNumberGenerate(length);
            }
            startGame(secretCode);
        }


    }

    private static void startGame(String secretCode) {
        Scanner scanner = new Scanner(System.in);
        Game game = new Game(secretCode);

        while (game.isWorking()) {
            game.execute(scanner.nextLine());
        }
    }

    private static String pseudoNumberGenerate(int number) {
        String pseudoOne = String.valueOf(System.nanoTime());
        char[] chars = pseudoOne.toCharArray();
        Set<Character> charSet = new LinkedHashSet<>();
        for (char c : chars) {
            charSet.add(c);
        }
        StringBuilder sb = new StringBuilder();
        for (Character character : charSet) {
            sb.append(character);
        }
        while (sb.charAt(0) == 0) {
            sb.deleteCharAt(0);
        }
        return sb.substring(0, number);
    }
}
