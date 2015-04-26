package tennis;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KeepScoreTest {

    Player player1;
    Player player2;
    TennisGame game;

    @Before
    public void setUp() throws Exception {
        player1 = new Player("John");
        player2 = new Player("Ivan");
        game = new TennisGame(player1, player2);
    }

    private void scorePoints(Player player, int points) {
        for (int i = 0; i < points; i++) {
            game.scorePointFor(player);
        }
    }

    @Test
    public void newScoreStartsAtZero() {
        assertEquals(0, game.getPointsFor(player1).intValue());
        assertEquals(0, game.getPointsFor(player2).intValue());
    }

    @Test
    public void addOnePointToScore() {
        scorePoints(player1, 1);
        assertEquals(1, game.getPointsFor(player1).intValue());
        assertEquals(0, game.getPointsFor(player2).intValue());
    }


    @Test
    public void addMultiplePointsToScore() {
        scorePoints(player1, 3);
        scorePoints(player2, 1);
        assertEquals(3, game.getPointsFor(player1).intValue());
        assertEquals(1, game.getPointsFor(player2).intValue());
    }


}
