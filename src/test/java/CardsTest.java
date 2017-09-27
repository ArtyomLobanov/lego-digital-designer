import cards.Card;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CardsTest {

    @Test
    public void getPoints() {
        Card card = new Card(Card.Value.JACK, Card.Suit.DIAMONDS);
        assertTrue(card.getPoints(12) == 2);
        card = new Card(Card.Value.TWO, Card.Suit.HEARTS);
        assertTrue(card.getPoints(2) == 2);
        card = new Card(Card.Value.TEN, Card.Suit.CLUBS);
        assertTrue(card.getPoints(3) == 10);
        card = new Card(Card.Value.TEN, Card.Suit.HEARTS);
        assertTrue(card.getPoints(5) == 10);
        card = new Card(Card.Value.NINE, Card.Suit.SPADES);
        assertTrue(card.getPoints(17) == 9);
        card = new Card(Card.Value.QUEEN, Card.Suit.DIAMONDS);
        assertTrue(card.getPoints(123) == 3);
        card = new Card(Card.Value.KING, Card.Suit.HEARTS);
        assertTrue(card.getPoints(92) == 4);
    }

    @Test
    public void getSuit() {
        Card card = new Card(Card.Value.JACK, Card.Suit.DIAMONDS);
        assertTrue(card.getSuit() == Card.Suit.DIAMONDS);
        card = new Card(Card.Value.ACE, Card.Suit.SPADES);
        assertTrue(card.getSuit() == Card.Suit.SPADES);
    }

    @Test
    public void getValue() {
        Card card = new Card(Card.Value.JACK, Card.Suit.DIAMONDS);
        assertTrue(card.getValue() == Card.Value.JACK);
        card = new Card(Card.Value.JACK, Card.Suit.CLUBS);
        assertTrue(card.getValue() == Card.Value.JACK);
        card = new Card(Card.Value.JACK, Card.Suit.HEARTS);
        assertTrue(card.getValue() == Card.Value.JACK);
        card = new Card(Card.Value.QUEEN, Card.Suit.DIAMONDS);
        assertTrue(card.getValue() == Card.Value.QUEEN);
    }

    @Test
    public void getAcePoints() {
        Card card = new Card(Card.Value.ACE, Card.Suit.SPADES);
        assertTrue(card.getPoints(0) == 11);
        assertTrue(card.getPoints(5) == 11);
        assertTrue(card.getPoints(10) == 11);
        assertTrue(card.getPoints(11) == 1);
        assertTrue(card.getPoints(20) == 1);
    }

    @Test
    public void testEquals() {
        Card card1 = new Card(Card.Value.ACE, Card.Suit.SPADES);
        Card card2 = new Card(Card.Value.ACE, Card.Suit.HEARTS);
        assertFalse(card1.equals(card2));
        assertFalse(card2.equals(card1));

        card1 = new Card(Card.Value.TWO, Card.Suit.SPADES);
        card2 = new Card(Card.Value.ACE, Card.Suit.SPADES);
        assertFalse(card1.equals(card2));
        assertFalse(card2.equals(card1));

        card1 = new Card(Card.Value.TWO, Card.Suit.CLUBS);
        card2 = new Card(Card.Value.TWO, Card.Suit.CLUBS);
        assertTrue(card1.equals(card2));
        assertTrue(card2.equals(card1));

        card1 = new Card(Card.Value.TWO, Card.Suit.SPADES);
        card2 = null;
        assertFalse(card1.equals(card2));
    }
}
