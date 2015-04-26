package tennis;

import java.util.HashMap;
import java.util.Map;

public class TennisGame {
    private static final int MIN_POINTS_FOR_DEUCE = 3;
    private static final int MIN_POINTS_FOR_WINNING = 4;
    private static final int NEEDED_DIFFERENCE_FOR_WINNING = 1;
    private final Player player1;
    private final Player player2;
    private final Map<Player, Integer> score = new HashMap<>(2);
    private final Map<Player, Points> score2 = new HashMap<>(2);


    public TennisGame(Player player1, Player player2) {
        score.put(player1, 0);
        score.put(player2, 0);
        score2.put(player1, new Points());
        score2.put(player2, new Points());
        this.player1 = player1;
        this.player2 = player2;
    }

    public void scorePointFor(Player player) {
        score.put(player, getPointsFor(player) + 1);
        score2.get(player).addOne();
    }

    public int getPointsFor(Player player) {
        return score.get(player);
    }
    public Points getPointsFor2(Player player) {
        return score2.get(player);
    }

    public String getScore() {
        if (isTied()) {
            return getTiedScore();
        } else {
            return getUntiedScore();
        }
    }

    private boolean isTied() {
        return getPointsFor(player1) == getPointsFor(player2) && getPointsFor2(player1).equals(getPointsFor2(player2));
    }

    private String getTiedScore() {
        if (gameHasReachedDeuceStage()) {
            return "Deuce";
        } else {
            return String.format("%s all", pointsToString(player1));
        }
    }

    private String getUntiedScore() {
        if (onePlayerHasWonTheGame()) {
            return String.format("Game %s", getPlayerWithMostPoints().getName());
        } else if (gameHasReachedDeuceStage()) {
            return String.format("Advantage %s", getPlayerWithMostPoints().getName());
        } else {
            return String.format("%s - %s", pointsToString(player1), pointsToString(player2));
        }
    }

    private boolean onePlayerHasWonTheGame() {
        return hasWonGame(player1) || hasWonGame(player2);
    }

    private boolean hasWonGame(Player player) {
        Player otherPlayer = player.equals(player1) ? player2 : player1;
        return getPointsFor(player) >= MIN_POINTS_FOR_WINNING && getPointsFor(player) > getPointsFor(otherPlayer) + NEEDED_DIFFERENCE_FOR_WINNING
        && getPointsFor2(player).areEnoughForWinningTheGame() && getPointsFor2(player).areMoreThan(getPointsFor2(otherPlayer).add(NEEDED_DIFFERENCE_FOR_WINNING));
    }


    private boolean gameHasReachedDeuceStage() {
        return getPointsFor(player1) >= MIN_POINTS_FOR_DEUCE && getPointsFor(player2) >= MIN_POINTS_FOR_DEUCE
        && getPointsFor2(player1).areEnoughForDeuce() && getPointsFor2(player2).areEnoughForDeuce();
    }

    private Player getPlayerWithMostPoints() {
        if (getPointsFor(player1) > getPointsFor(player2)
                && getPointsFor2(player1).areMoreThan( getPointsFor2(player2))) {
            return player1;
        } else {
            return player2;
        }
    }

    private String pointsToString(Player player) {
        return getPointsFor2(player).toString();
    }
}
