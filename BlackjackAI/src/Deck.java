import java.util.ArrayList;

public class Deck {
    ArrayList<CardDT> cards = new ArrayList<>();

    public void ShuffleDeck(){
        for (int i = 0; i < 100000 ; i++) {
            int min = 1;
            int max = cards.size();
            double randomNumber = min + (Math.random() * (max - min + 1));
            int random = (int) randomNumber - 1;
            CardDT tempcard = cards.get(random);
            cards.remove(random);
            cards.add(tempcard);
            System.out.println("Shuffeld " + i);
        }
    }
    public void InitualizeNewDeck(){
        String shape[] = {"hearts", "Diamonds", "Spades", "Clubs"};
        int value[] = {1,2,3,4,5,6,7,8,9,10,10,10,10};

        for (int i = 0; i < shape.length; i++) {
            System.out.println("Begin nieuwe shape-----------------");
            for (int j = 0; j < value.length; j++) {
                CardDT cardDT = new CardDT();
                System.out.println("Ik voeg " + shape[i] + value[j] + " toe");
                cardDT.value = value[j];
                cardDT.shape = shape[i];

                System.out.println("check " + cardDT.shape + " value of " + cardDT.value);
                this.cards.add(cardDT);

            }
        }
    }
}
