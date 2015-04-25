package tennis;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TranslateScoreTest {

    @Test
    public void playerOneScores() {
Score score = new Score();
        score.addPlayer1Point();
        assertEquals("Fifteen - Love", score.toString());
        score.addPlayer1Point();
        assertEquals("Thirty - Love", score.toString());
        score.addPlayer1Point();
        assertEquals("Forty - Love", score.toString());
    }

    @Test
    public void playerTwoScores() {
        Score score = new Score();
        score.addPlayer2Point();
        assertEquals("Love - Fifteen", score.toString());
    }

}
