import java.util.ArrayList;
import java.util.Scanner;

//todo: add blackjack mechanism
public class Game {
    ArrayList<CardDT> dealerCards = new ArrayList<>();
    ArrayList<CardDT> playerCards = new ArrayList<>();
    Deck deck = new Deck();
    Scanner scanner = new Scanner(System.in);

    public Game() {
        //Starts the game and deals the cards
        CardDT cards = new CardDT();
        //getting the Deck
        deck.InitualizeNewDeck();
        deck.ShuffleDeck();

        //dealing the cards
        dealerCards.add(deck.GetCard());
        dealerCards.add(deck.GetCard());
        playerCards.add(deck.GetCard());
        playerCards.add(deck.GetCard());

        //printing the cards to the user
        PrintCards(playerCards, "Player", true);
        System.out.println("________________________________________________________________");
        PrintCards(dealerCards, "dealer", false);

        if (CountPoints(playerCards) == 21) {
            System.out.println("Blackjack");
        }
        System.out.println("________________________________________________________________");
        System.out.println("You have: " + CountPoints(playerCards) + " points");
        System.out.println("________________________________________________________________");
        String input = "";
        System.out.println("do you want to hit?[y/n]");
        do {
            PrintCards(playerCards, "player", true);
            System.out.println(CountPoints(playerCards));
            input = scanner.nextLine();
            System.out.println("Total points are: " + CountPoints(playerCards));
            if (input.equals("y") || input.equals("Y")) {
                Hit("player");
                System.out.println("do you want to hit?[y/n]");
            } else {
                System.out.println("ok");
                break;
            }
        } while (CountPoints(playerCards) <= 21 && CountPoints(playerCards) != 0);
        System.out.println(CountPoints(playerCards));
        PrintCards(dealerCards, "dealer", true);
        Dealer();
        System.out.println("The dealers total points are " + CountPoints(dealerCards));
        winner();
    }

    public void winner() {
        int dealerPoints = CountPoints(dealerCards);
        int playerPoints = CountPoints(playerCards);

        if (dealerPoints > 21) {
            dealerPoints = 0;
        }
        if (playerPoints > 21) {
            playerPoints = 0;
        }

        if (playerPoints > dealerPoints) {
            System.out.println("you win");

        } else if (playerPoints == dealerPoints) {
            System.out.println("Draw");
        } else {
            System.out.println("dealer wins");
        }
    }

    public void Dealer() {
        while (1 == 1) {
            int dealerTotal = CountPoints(dealerCards);
            if (dealerTotal < 17) {
                Hit("dealer");
                System.out.println("________________________________________________________________");
                System.out.println("The dealer has a new card");
                PrintCards(dealerCards, "dealer", true);
            } else {
                break;
            }
        }
    }

    public void PrintCards(ArrayList<CardDT> cards, String entity, boolean all) {
        int amoundOfLoops = 0;
        if (all) {
            amoundOfLoops = cards.size();
        } else {
            amoundOfLoops = 1;
        }
        for (int i = 0; i < amoundOfLoops; i++) {
            String ValueOfCard = "";
            int cardValue = cards.get(i).value;
            if (cardValue == 1) {
                ValueOfCard = "Ace";
            } else {
                ValueOfCard = String.valueOf(cardValue);
            }
            System.out.println("The " + entity + " has " + cards.get(i).shape + " " + ValueOfCard);
        }
    }

    public int CountPoints(ArrayList<CardDT> cards) {
        int total = 0;
        int amoundOfAces = 0;
        //counting the aces
        for (int i = 1; i <= cards.size(); i++) {
            int number;
            number = cards.get(i - 1).value;
            if (number == 1) {
                amoundOfAces++;
                total = total + number;
            } else {
                total = total + number;
            }
        }
        return total;
    }

    public void Hit(String entity) {
        if (entity.equals("player")) {
            playerCards.add(deck.GetCard());
        } else {
            dealerCards.add(deck.GetCard());
        }
    }

    public void Payout() {
        //todo make a payout system for the bet
    }
}
