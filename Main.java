package bullscows;


import java.util.*;

import static bullscows.GameOutput.*;

public class Main {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);
        chooseGameLevelMessage();

        int length = scanner.nextInt();
        if (length > 10) {
            outOfLimitMessage(length);
        } else {
            startMessage();
            startGame(randomGenerator(length));
        }
    }

    private static void startGame(String secretCode) {
        Scanner scanner = new Scanner(System.in);
        Game game = new Game(secretCode);

        while (game.isWorking()) {
            game.execute(scanner.nextLine());
        }
    }

    private static String randomGenerator(int number) {
        List<Character> numbers = Arrays.asList('0','1','2','3','4','5','6','7','8','9');
        StringBuilder sb = new StringBuilder();
        while (numbers.get(0) == '0') {
            Collections.shuffle(numbers);
        }
        for (Character character : numbers) {
            sb.append(character);
        }
        return sb.substring(0, number);
    }
}
