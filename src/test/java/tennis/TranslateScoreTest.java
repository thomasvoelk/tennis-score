package tennis;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TranslateScoreTest extends ScoreTestBase {


    @Test
    public void onlyPlayerOneScores() {
        addPoints(player1, 1);
        assertEquals("Fifteen - Love", score.toString());
        addPoints(player1, 1);
        assertEquals("Thirty - Love", score.toString());
        addPoints(player1, 1);
        assertEquals("Forty - Love", score.toString());
    }

    @Test
    public void onlyPlayerTwoScores() {
        addPoints(player2, 1);
        assertEquals("Love - Fifteen", score.toString());
        addPoints(player2, 1);
        assertEquals("Love - Thirty", score.toString());
        addPoints(player2, 1);
        assertEquals("Love - Forty", score.toString());
    }

    @Test
    public void bothPlayersScore_butNoTie() {
        addPoints(player1, 2);
        addPoints(player2, 1);
        assertEquals("Thirty - Fifteen", score.toString());
        addPoints(player2, 2);
        assertEquals("Thirty - Forty", score.toString());
    }

    @Test
    public void tiedScore_upTo30() {
        assertEquals("Love all", score.toString());
        addPoints(player1, 1);
        addPoints(player2, 1);
        assertEquals("Fifteen all", score.toString());
        addPoints(player1, 1);
        addPoints(player2, 1);
        assertEquals("Thirty all", score.toString());
    }

    @Test
    public void deuce() {
        addPoints(player1, 3);
        addPoints(player2, 3);
        assertEquals("Deuce", score.toString());
    }

    @Test
    public void advantagePlayer1() {
        addPoints(player1, 3);
        addPoints(player2, 3);
        addPoints(player1, 1);
        assertEquals("Advantage " + player1.getName(), score.toString());
    }

    @Test
    public void advantagePlayer2() {
        addPoints(player1, 3);
        addPoints(player2, 3);
        addPoints(player2, 1);
        assertEquals("Advantage " + player2.getName(), score.toString());
    }

}
