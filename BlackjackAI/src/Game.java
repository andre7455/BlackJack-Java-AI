import java.util.ArrayList;

public class Game {
    public Game(){
        //Starts the game and deals the cards
        CardDT cards = new CardDT();
        //getting the Deck
        Deck deck = new Deck();
        deck.InitualizeNewDeck();
        deck.ShuffleDeck();

        ArrayList<CardDT> dealerCards = new ArrayList<>();
        ArrayList<CardDT> playerCards = new ArrayList<>();

        dealerCards.add(deck.GetCard());
        dealerCards.add(deck.GetCard());

        playerCards.add(deck.GetCard());
        playerCards.add(deck.GetCard());

        for (int i = 0; i < playerCards.size(); i++) {
            System.out.println("The Player has " + playerCards.get(i).shape + " " + playerCards.get(i).value);
        }
        System.out.println("________________________________________________________________");
        System.out.println("The dealer has " + dealerCards.get(1).shape + " " + dealerCards.get(1).value);
    }
    public void Stay(){
        //todo i dont know how but make this
    }

    public void Hit(){

    }

    public void CheckIfBust(){
        //todo check for blackjack but idk yet how to implement
        //for (int i = 0; i < ; i++) {}
    }
}
