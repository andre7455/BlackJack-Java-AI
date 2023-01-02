import java.util.ArrayList;

public class Deck {
    ArrayList<CardDT> cards = new ArrayList<>();

    public CardDT GetCard(){
        //todo maybe make the random card index generator a method in and of itself
        int min = 1;
        int max = cards.size();
        double randomNumber = min + (Math.random() * (max - min + 1));
        int random = (int) randomNumber - 1;

        CardDT drawnCard = cards.get(random);
        cards.remove(random);
        return drawnCard;
    }
    public void ShuffleDeck(){
        for (int i = 0; i < 100000 ; i++) {
            int min = 1;
            int max = cards.size();
            double randomNumber = min + (Math.random() * (max - min + 1));
            int random = (int) randomNumber - 1;
            CardDT tempcard = cards.get(random);
            cards.remove(random);
            cards.add(tempcard);
        }
    }
    public void InitualizeNewDeck(){
        String shape[] = {"hearts", "Diamonds", "Spades", "Clubs"};
        int value[] = {1,2,3,4,5,6,7,8,9,10,10,10,10};

        for (int i = 0; i < shape.length; i++) {
            for (int j = 0; j < value.length; j++) {
                CardDT cardDT = new CardDT();
                cardDT.value = value[j];
                cardDT.shape = shape[i];
                this.cards.add(cardDT);

            }
        }
    }
}
