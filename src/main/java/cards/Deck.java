package cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Deck {

    private final List<Card> cards = new ArrayList<>();
    private int position = 0;

    public Deck() {
        for (Card.Suit suit : Card.Suit.values()) {
            for (Card.Value value : Card.Value.values()) {
                cards.add(new Card(value, suit));
            }
        }
        Collections.shuffle(cards, new Random(228));
    }

    public Card getCard() throws DeckIsEmptyException {
        if (position >= cards.size()) {
            throw new DeckIsEmptyException();
        }
        return cards.get(position++);
    }
}
