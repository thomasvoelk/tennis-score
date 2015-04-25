package tennis;

import org.junit.Before;

public class ScoreTestBase {
    protected Player player1;
    protected Player player2;
    protected Score score;

    @Before
    public void setUp() throws Exception {
        player1 = new Player("John");
        player2 = new Player("Ivan");
        score = new Score(player1, player2);
    }

    protected void addPlayer1Points(int points) {
        for (int i = 0; i < points; i++) {
            score.scorePointFor(player1);
        }
    }

    protected void addPlayer2Points(int points) {
        for (int i = 0; i < points; i++) {
            score.scorePointFor(player2);
        }
    }
}
