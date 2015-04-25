package tennis;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TranslateScoreTest extends ScoreTestBase {



    @Test
    public void onlyPlayerOneScores() {
        score.scorePointFor(player1);
        assertEquals("Fifteen - Love", score.toString());
        score.scorePointFor(player1);
        assertEquals("Thirty - Love", score.toString());
        score.scorePointFor(player1);
        assertEquals("Forty - Love", score.toString());
    }

    @Test
    public void onlyPlayerTwoScores() {
        score.scorePointFor(player2);
        assertEquals("Love - Fifteen", score.toString());
        score.scorePointFor(player2);
        assertEquals("Love - Thirty", score.toString());
        score.scorePointFor(player2);
        assertEquals("Love - Forty", score.toString());
    }

    @Test
    public void bothPlayersScore_butNoTie() {
        addPlayer1Points(2);
        score.scorePointFor(player2);
        assertEquals("Thirty - Fifteen", score.toString());
        addPlayer2Points(2);
        assertEquals("Thirty - Forty", score.toString());
    }

    @Test
    public void tiedScore_upTo30() {
        assertEquals("Love all", score.toString());
        score.scorePointFor(player1);
        score.scorePointFor(player2);
        assertEquals("Fifteen all", score.toString());
        score.scorePointFor(player1);
        score.scorePointFor(player2);
        assertEquals("Thirty all", score.toString());
    }

    @Test
    public void deuce() {
        addPlayer1Points(3);
        addPlayer2Points(3);
        assertEquals("Deuce", score.toString());
    }

    @Ignore("Till we switched to Player Class")
    @Test
    public void advantage() {
        addPlayer1Points(3);
        addPlayer2Points(3);
        addPlayer1Points(1);
        assertEquals("Advantage 1", score.toString());
    }

}
