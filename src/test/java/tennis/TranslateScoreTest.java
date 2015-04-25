package tennis;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TranslateScoreTest extends ScoreTestBase {


    @Test
    public void onlyPlayerOneScores() {
        scorePoints(player1, 1);
        assertEquals("Fifteen - Love", game.getScore());
        scorePoints(player1, 1);
        assertEquals("Thirty - Love", game.getScore());
        scorePoints(player1, 1);
        assertEquals("Forty - Love", game.getScore());
    }

    @Test
    public void onlyPlayerTwoScores() {
        scorePoints(player2, 1);
        assertEquals("Love - Fifteen", game.getScore());
        scorePoints(player2, 1);
        assertEquals("Love - Thirty", game.getScore());
        scorePoints(player2, 1);
        assertEquals("Love - Forty", game.getScore());
    }

    @Test
    public void bothPlayersScore_butNoTie() {
        scorePoints(player1, 2);
        scorePoints(player2, 1);
        assertEquals("Thirty - Fifteen", game.getScore());
        scorePoints(player2, 2);
        assertEquals("Thirty - Forty", game.getScore());
    }

    @Test
    public void tiedScore_upTo30() {
        assertEquals("Love all", game.getScore());
        scorePoints(player1, 1);
        scorePoints(player2, 1);
        assertEquals("Fifteen all", game.getScore());
        scorePoints(player1, 1);
        scorePoints(player2, 1);
        assertEquals("Thirty all", game.getScore());
    }

    @Test
    public void deuce() {
        scorePoints(player1, 3);
        scorePoints(player2, 3);
        assertEquals("Deuce", game.getScore());
    }

    @Test
    public void advantagePlayer1() {
        scorePoints(player1, 3);
        scorePoints(player2, 3);
        scorePoints(player1, 1);
        assertEquals("Advantage John", game.getScore());
    }

    @Test
    public void advantagePlayer2() {
        scorePoints(player1, 3);
        scorePoints(player2, 3);
        scorePoints(player2, 1);
        assertEquals("Advantage Ivan", game.getScore());
    }

    @Test
    public void gamePlayer1() {
        scorePoints(player1, 4);
        assertEquals("Game John", game.getScore());
    }

    @Test
    public void gamePlayer2() {
        scorePoints(player2, 4);
        assertEquals("Game Ivan", game.getScore());
    }

}
