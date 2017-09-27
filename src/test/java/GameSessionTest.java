import cards.DeckIsEmptyException;
import game.GameSession;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class GameSessionTest {

    @Test
    public void whoseTurn() throws DeckIsEmptyException {
        GameSession gameSession = new GameSession();
        assertNotNull(gameSession.getTurn());
    }

    @Test
    public void cardsTest() throws DeckIsEmptyException {
        GameSession gameSession = new GameSession();
        assertNotNull(gameSession.getCards(GameSession.Turn.PLAYER));
        assertNotNull(gameSession.getCards(GameSession.Turn.DEALER));
    }


}
