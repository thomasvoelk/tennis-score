package tennis;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TranslateScoreTest {

    private Score score;

    @Before
    public void setUp() throws Exception {
        score = new Score();
    }

    private void addPlayer1Points(int points) {
        for (int i = 0; i < points; i++) {
            score.addPlayer1Point();
        }
    }

    private void addPlayer2Points(int points) {
        for (int i = 0; i < points; i++) {
            score.addPlayer2Point();
        }
    }

    @Test
    public void onlyPlayerOneScores() {
        score.addPlayer1Point();
        assertEquals("Fifteen - Love", score.toString());
        score.addPlayer1Point();
        assertEquals("Thirty - Love", score.toString());
        score.addPlayer1Point();
        assertEquals("Forty - Love", score.toString());
    }

    @Test
    public void onlyPlayerTwoScores() {
        score.addPlayer2Point();
        assertEquals("Love - Fifteen", score.toString());
        score.addPlayer2Point();
        assertEquals("Love - Thirty", score.toString());
        score.addPlayer2Point();
        assertEquals("Love - Forty", score.toString());
    }

    @Test
    public void bothPlayersScore_butNoTie() {
        addPlayer1Points(2);
        score.addPlayer2Point();
        assertEquals("Thirty - Fifteen", score.toString());
        addPlayer2Points(2);
        assertEquals("Thirty - Forty", score.toString());
    }

    @Test
    public void tiedScore_upTo30() {
        assertEquals("Love all", score.toString());
        score.addPlayer1Point();
        score.addPlayer2Point();
        assertEquals("Fifteen all", score.toString());
        score.addPlayer1Point();
        score.addPlayer2Point();
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
