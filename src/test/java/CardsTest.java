import cards.Card;
import org.junit.Test;

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
}
