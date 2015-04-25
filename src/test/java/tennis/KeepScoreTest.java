package tennis;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KeepScoreTest extends ScoreTestBase {

    @Test
    public void newScoreStartsAtZero() {
        assertEquals(0, game.getPointsFor(player1));
        assertEquals(0, game.getPointsFor(player2));
    }

    @Test
    public void addOnePointToScore() {
        scorePoints(player1, 1);
        assertEquals(1, game.getPointsFor(player1));
        assertEquals(0, game.getPointsFor(player2));
    }


    @Test
    public void addMultiplePointsToScore() {
        scorePoints(player1, 3);
        scorePoints(player2, 1);
        assertEquals(3, game.getPointsFor(player1));
        assertEquals(1, game.getPointsFor(player2));
    }


}
