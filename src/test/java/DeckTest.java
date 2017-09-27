import cards.Card;
import cards.Deck;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class DeckTest {

    @Test
    public void getCard() {
        assertTrue(new Deck().getCard() != null);
    }

    @Test
    public void differentCards() {
        Set<Card> cards = new HashSet<>();
        Deck deck = new Deck();
        for (int i = 0; i < 52; i++) {
            cards.add(deck.getCard());
        }
        assertEquals(52, cards.size());
    }
}
