package bullscows;


import java.util.*;

import static bullscows.GameOutput.*;

public class Main {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        System.out.println();
        lengthLevelMessage();
        int length = inputNumber();
        rangeLevelMessage();
        int range = inputNumber();
        checkInput(length, range);

    }

    private static int inputNumber() {
        String mInput = new Scanner(System.in).nextLine();
        int num = 0;
        try {
            num = Integer.parseInt(mInput);
        } catch (NumberFormatException e){
            System.out.printf("\"%s\" isn't a valid number.", mInput);
        }
        finally {
            if (num == 0) {
                System.out.println("error");
                System.exit(0);
            }
        }
        return num;
    }

    private static void checkInput(int length, int range) {
        if (range >= length) {
            if (range <= 36) {
                if (length <= 10) {
                    tipMessage(length, range);
                    startMessage();
                    startGame(randomGenerator(length, range));
                } else {
                    outOfLimitMessage(length);
                }
            } else {
                outOfRangeMessage();
            }
        } else {
            wrongInput(length, range);
            System.exit(0);
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
