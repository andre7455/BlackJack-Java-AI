import java.util.ArrayList;

public class Deck {
    ArrayList<CardDT> cards = new ArrayList<>();

    public CardDT GetCard() {
        //todo maybe make the random card index generator a method in and of itself
        int min = 1;
        int max = cards.size();
        double randomNumber = min + (Math.random() * (max - min + 1));
        int random = (int) randomNumber - 1;

        CardDT drawnCard = cards.get(random);
        cards.remove(random);
        return drawnCard;
    }

    public void ShuffleDeck() {
        for (int i = 0; i < 1; i++) {
            int min = 1;
            int max = cards.size();
            double randomNumber = min + (Math.random() * (max - min + 1));
            int random = (int) randomNumber - 1;
            CardDT tempcard = cards.get(random);
            cards.remove(random);
            cards.add(tempcard);
        }
    }

    public int CountPoints(ArrayList<CardDT> cards) {
        int total = 0;
        int amoundOfAces = 0;
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
                        total = total + 10;
                    }
                }
            }
        }
        if (total > 21) {
            total = 0;
        }
        return total;
    }

    public void InitualizeNewDeck() {
        String shape[] = {"Hearts", "Diamonds", "Spades", "Clubs"};
        int value[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10};

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
