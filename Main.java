package bullscows;


import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        /*String secretCode = "9305";//scanner.nextInt();

        Game game = new Game(secretCode);


        while (game.isWorking()) {
            game.execute(scanner.nextLine());
        }*/
        int number = scanner.nextInt();
        String digit = "";
        if (number > 10) {
            System.out.printf("Error: can't generate a secret number with a length of %d because there aren't enough unique digits.\n", number);
        } else {
            while (digit.length() < number) {
                digit = pseudoNumberGenerate(number);
            }
            System.out.println("The random secret number is " + digit + ".");
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
