import cards.Card;
import cards.Deck;
import cards.DeckIsEmptyException;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

public class DeckTest {

    @Test
    public void getCard() throws DeckIsEmptyException {
        Card card = new Deck().getCard();
        assertNotNull(card);
        assertNotNull(card.getSuit());
        assertNotNull(card.getValue());
    }

    @Test
    public void differentCards() throws DeckIsEmptyException {
        Set<Card> cards = new HashSet<>();
        Deck deck = new Deck();
        for (int i = 0; i < 52; i++) {
            cards.add(deck.getCard());
        }
        assertEquals(52, cards.size());
    }

    @Test(expected = DeckIsEmptyException.class)
    public void isEmpty() throws DeckIsEmptyException {
        Deck deck = new Deck();
        for (int i = 0; i < 53; i++) {
            deck.getCard();
        }
    }
}
