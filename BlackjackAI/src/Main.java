public class Main {
    //dealer has to go until 17 or more even if your cards are lower
    public static void main(String[] args) {
        //making filling and shuffling a deck
        Deck deck = new Deck();
        deck.InitualizeNewDeck();
        deck.ShuffleDeck();
    }
}