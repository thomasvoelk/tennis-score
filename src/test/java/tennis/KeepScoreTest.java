package tennis;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KeepScoreTest {

    @Test
    public void newScoreStartsAtZero() {
        Score score = new Score();
        assertEquals(0, score.getPlayer1Points());
        assertEquals(0, score.getPlayer2Points());
    }

    @Test
    public void addOnePointToScore() {
        Score score = new Score();
        score.addPlayer1Point();
        assertEquals(1, score.getPlayer1Points());
        assertEquals(0, score.getPlayer2Points());
    }


    @Test
    public void addMultiplePointsToScore() {
        Score score = new Score();
        score.addPlayer1Point();
        score.addPlayer1Point();
        score.addPlayer1Point();
        score.addPlayer2Point();
        assertEquals(3, score.getPlayer1Points());
        assertEquals(1, score.getPlayer2Points());
    }


}
