package tennis;

import org.junit.Before;

public class ScoreTestBase {
    Player player1;
    Player player2;
    TennisGame game;

    @Before
    public void setUp() throws Exception {
        player1 = new Player("John");
        player2 = new Player("Ivan");
        game = new TennisGame(player1, player2);
    }

    void scorePoints(Player player, int points) {
        for (int i = 0; i < points; i++) {
            game.scorePointFor(player);
        }
    }
}
