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

    public int getPlayer1Points() {
        return pointsForPlayer(player1);
    }

    public void addPlayer1Point() {
        points.put(player1, pointsForPlayer(player1) + 1);
    }

    public int getPlayer2Points() {
        return pointsForPlayer(player2);
    }

    public void addPlayer2Point() {
        points.put(player2, pointsForPlayer(player2) + 1);
    }

    @Override
    public String toString() {
        int player1Points = pointsForPlayer(player1);
        int player2Points = pointsForPlayer(player2);
        String score1 = pointsToString(player1Points);
        String score2 = pointsToString(player2Points);
        if (player1Points != player2Points) {
            return String.format("%s - %s", score1, score2);
        } else if(player1Points < 3) {
            return String.format("%s all", score1);
        } else {
            return "Deuce";
        }
    }

    private int pointsForPlayer(Player player ) {
        return points.get(player);
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
