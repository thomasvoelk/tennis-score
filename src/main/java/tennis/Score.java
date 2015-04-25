package tennis;

public class Score {
    private final Player player1;
    private final Player player2;
    private int player1Points;
    private int player2Points;

    public Score(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public int getPlayer1Points() {
        return player1Points;
    }

    public void addPlayer1Point() {
        player1Points++;
    }

    public int getPlayer2Points() {
        return player2Points;
    }

    public void addPlayer2Point() {
        player2Points++;
    }

    @Override
    public String toString() {
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
