import java.util.Scanner;

public class Main {
    //dealer has to go until 17 or more even if your cards are lower
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //making filling and shuffling a deck
        Game game = new Game();
        System.out.println(game.CountPoints(game.playerCards));
        System.out.println("do you want to hit?[y/n]");
        String input = scanner.nextLine();
        if (input.equals("y")) {
            game.Hit();

        } else {
            System.out.println("ok");
        }

        game.PrintCards(game.playerCards, "player", true);
        System.out.println(game.CountPoints(game.playerCards));


    }
}