package tennis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class TennisTest {

    private int player1Score;
    private int player2Score;
    private String expectedScore;

    public TennisTest(int player1Score, int player2Score, String expectedScore) {
        this.player1Score = player1Score;
        this.player2Score = player2Score;
        this.expectedScore = expectedScore;
    }

    @Parameters
    public static Collection<Object[]> getAllScores() {
        return Arrays.asList(new Object[][]{
                {0, 0, "Love all"},
                {1, 1, "Fifteen all"},
                {2, 2, "Thirty all"},
                {3, 3, "Deuce"},
                {4, 4, "Deuce"},

                {1, 0, "Fifteen - Love"},
                {0, 1, "Love - Fifteen"},
                {2, 0, "Thirty - Love"},
                {0, 2, "Love - Thirty"},
                {3, 0, "Forty - Love"},
                {0, 3, "Love - Forty"},
                {4, 0, "Game player1"},
                {0, 4, "Game player2"},

                {2, 1, "Thirty - Fifteen"},
                {1, 2, "Fifteen - Thirty"},
                {3, 1, "Forty - Fifteen"},
                {1, 3, "Fifteen - Forty"},
                {4, 1, "Game player1"},
                {1, 4, "Game player2"},

                {3, 2, "Forty - Thirty"},
                {2, 3, "Thirty - Forty"},
                {4, 2, "Game player1"},
                {2, 4, "Game player2"},

                {4, 3, "Advantage player1"},
                {3, 4, "Advantage player2"},
                {5, 4, "Advantage player1"},
                {4, 5, "Advantage player2"},
                {15, 14, "Advantage player1"},
                {14, 15, "Advantage player2"},

                {6, 4, "Game player1"},
                {4, 6, "Game player2"},
                {16, 14, "Game player1"},
                {14, 16, "Game player2"},
        });
    }

    public void checkAllScores(TennisGame game) {
        Player player1 = new Player("player1");
        Player player2 = new Player("player2");
        int highestScore = Math.max(this.player1Score, this.player2Score);
        for (int i = 0; i < highestScore; i++) {
            if (i < this.player1Score)
                game.scorePointFor(player1);
            if (i < this.player2Score)
                game.scorePointFor(player2);
        }
        assertEquals(this.expectedScore, game.getScore());
    }

    @Test
    public void checkAllScoresTennisGame1() {
        Player player1 = new Player("player1");
        Player player2 = new Player("player2");
        TennisGame game = new TennisGame(player1, player2);
        checkAllScores(game);
    }

}
