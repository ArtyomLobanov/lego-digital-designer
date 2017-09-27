package cards;

public class Card {

    public enum Value {
        TWO,
        THREE,
        FOUR,
        FIVE,
        SIX,
        SEVEN,
        EIGHT,
        NINE,
        TEN,
        JACK,
        QUEEN,
        KING,
        ACE
    }

    public enum Suit {
        DIAMONDS,
        SPADES,
        CLUBS,
        HEARTS
    }

    private final Suit suit;
    private final Value value;

    public Card(Value value, Suit suit) {
        this.suit = suit;
        this.value = value;
    }

    public Suit getSuit() {
        return suit;
    }

    public int getPoints(int points) {
        switch (value) {
            case TWO: return 2;
            case THREE: return 3;
            case FOUR: return 4;
            case FIVE: return 5;
            case SIX: return 6;
            case SEVEN: return 7;
            case EIGHT: return 8;
            case NINE: return 9;
            case TEN: return 10;
            case JACK: return 2;
            case QUEEN: return 3;
            case KING: return 4;
            case ACE:
                if (points + 11 > 21) return 1;
                return 11;
            default:
                throw new UnsupportedOperationException("Broken card.");
        }
    }

    public Value getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Card)) return false;

        Card card = (Card) o;

        if (suit != card.suit) return false;
        return value == card.value;
    }

    @Override
    public int hashCode() {
        int result = suit.hashCode();
        result = 31 * result + value.hashCode();
        return result;
    }
}