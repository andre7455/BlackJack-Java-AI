public class Main {
    //dealer has to go until 17 or more even if your cards are lower
    public static void main(String[] args) {
        //making filling and shuffling a deck
        Game game = new Game();
        System.out.println(game.CountPoints(game.playerCards));
    }
}