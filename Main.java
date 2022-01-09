package bullscows;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String secretCode = "9305";//scanner.nextInt();

        Game game = new Game(secretCode);


        while (game.isWorking()) {
            game.execute(scanner.nextLine());
        }


    }

}
