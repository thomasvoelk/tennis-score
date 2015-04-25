package tennis;

import java.util.HashMap;
import java.util.Map;

public class Score {
    private final Player player1;
    private final Player player2;
    private final Map<Player, Integer> points = new HashMap<>(2);

    public Score(Player player1, Player player2) {
        points.put(player1, 0);
        points.put(player2, 0);
        this.player1 = player1;
        this.player2 = player2;
    }

    public void scorePointFor(Player player) {
        points.put(player, getPointsFor(player) + 1);
    }

    public int getPointsFor(Player player) {
        return points.get(player);
    }

    @Override
    public String toString() {
        int player1Points = getPointsFor(player1);
        int player2Points = getPointsFor(player2);
        String score1 = pointsToString(player1Points);
        String score2 = pointsToString(player2Points);
        if (!isTied()) {
            if (player1Points < 4 && player2Points < 4) {
                return String.format("%s - %s", score1, score2);
            } else if ((player1Points > 3 && player1Points > player2Points + 1) || player2Points > 3 && player2Points > player1Points + 1) {
                Player winner = player1Points > player2Points ? player1 : player2;
                return String.format("Game %s", winner.getName());
            } else {
                Player playerInFront = player1Points > player2Points ? player1 : player2;
                return String.format("Advantage %s", playerInFront.getName());
            }
        } else {
            return tiedScoreToString();
        }
    }


    private String tiedScoreToString() {
        if (getPointsFor(player1) < 3) {
            return String.format("%s all", pointsToString(getPointsFor(player1)));
        } else {
            return "Deuce";
        }
    }

    private boolean isTied() {
        return getPointsFor(player1) == getPointsFor(player2);
    }

    private String pointsToString(int points) {
        String score1 = "Love";
        if (points == 1) {
            score1 = "Fifteen";
        } else if (points == 2) {
            score1 = "Thirty";
        } else if (points == 3) {
            score1 = "Forty";
        }
        return score1;
    }
}
