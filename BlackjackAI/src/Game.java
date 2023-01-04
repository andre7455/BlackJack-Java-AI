import java.util.ArrayList;
import java.util.Scanner;

//todo: add blackjack mechanism
public class Game {
    ArrayList<CardDT> dealerCards = new ArrayList<>();
    ArrayList<CardDT> playerCards = new ArrayList<>();
    Deck deck = new Deck();
    double playerMoney = 100;

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

        if (total > 21) {
            return 0;
        } else {
            if (total == 21) {
                return total;
            } else if (amoundOfAces != 0) {
                for (int i = 0; i < amoundOfAces; i++) {
                    if (total + 10 > 21) {
                        total = total + 1;
                    } else {
                        total = total + 11;
                    }
                }
            }
        }
        return total;
    }

    public void Hit() {
        System.out.println("Do you want to hit or stay? [h/s]");
        Scanner scanner = new Scanner(System.in);
        while (1 == 1) {
            String input = scanner.nextLine();
            if (input.equals("h")) {
                playerCards.add(deck.GetCard());
                break;
                //todo add cards to the deck of the player and check if he is bust or not
            } else if (input.equals("s")) {
                break;
            }
        }

    }

    public void finish() {
        //todo: make a method that ends the game and appoints a winner or a draw
    }

    public void Payout() {
        //todo make a payout system for the bet
    }
}
