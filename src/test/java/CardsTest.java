import cards.Card;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CardsTest {

    @Test
    public void getValue() {
        Card card = new Card();
        assertTrue(card.getValue(0) != 0);
    }

    @Test
    public void getSuit() {
        Card card = new Card();
        assertTrue(card.getSuit() != null);
    }

    @Test
    public void getName() {
        Card card = new Card();
        assertTrue(card.getName() != null);
    }

    @Test
    public void getAceValue() {
        Card card = new Card();
        assertTrue(card.getValue(0) != 0);
    }

    @Test
    public void testEquals() {
        Card card1 = new Card();
        Card card2 = new Card();
        assertFalse(card1.equals(card2));
        assertFalse(card2.equals(card1));
    }
}
