package tennis;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KeepScoreTest extends ScoreTestBase {

    @Test
    public void newScoreStartsAtZero() {
        assertEquals(0, score.getPointsFor(player1));
        assertEquals(0, score.getPointsFor(player2));
    }

    @Test
    public void addOnePointToScore() {
        addPoints(player1, 1);
        assertEquals(1, score.getPointsFor(player1));
        assertEquals(0, score.getPointsFor(player2));
    }


    @Test
    public void addMultiplePointsToScore() {
        addPoints(player1, 3);
        addPoints(player2, 1);
        assertEquals(3, score.getPointsFor(player1));
        assertEquals(1, score.getPointsFor(player2));
    }


}
