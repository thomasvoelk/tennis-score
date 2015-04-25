package tennis;

public class Score {
    private int player1Points;
    private int player2Points;

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
        String score1 = getString(player1Points);
        String score2 = getString(player2Points);
        return String.format("%s - %s", score1, score2);
    }

    private String getString(int points) {
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
