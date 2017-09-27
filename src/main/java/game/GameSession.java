package game;

import cards.Card;
import cards.Deck;
import cards.DeckIsEmptyException;

import java.util.ArrayList;
import java.util.List;

public class GameSession {
    public enum Turn {
        PLAYER,
        DEALER
    }

    private Turn turn;
    private final int bet;
    private final Deck deck;
    private final List<Card> playersCards;
    private final List<Card> dealersCards;

    public GameSession(int bet) throws DeckIsEmptyException {
        this.bet = bet;
        turn = Turn.PLAYER;
        deck = new Deck();
        playersCards = new ArrayList<>();
        dealersCards = new ArrayList<>();
        playersCards.add(deck.getCard());
        dealersCards.add(deck.getCard());
        playersCards.add(deck.getCard());
        dealersCards.add(deck.getCard());
    }

    public Turn getTurn() {
        return turn;
    }

    public List<Card> getCards(Turn turn) {
        if (turn == Turn.PLAYER)
            return playersCards;
        return dealersCards;
    }

}
