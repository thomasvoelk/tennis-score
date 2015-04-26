package tennis;

import java.util.*;

class TennisGame {
    private static final int NEEDED_DIFFERENCE_FOR_WINNING = 1;
    private final Player player1;
    private final Player player2;
    private final Map<Player, Points> score = new HashMap<>(2);


    TennisGame(Player player1, Player player2) {
        score.put(player1, new Points());
        score.put(player2, new Points());
        this.player1 = player1;
        this.player2 = player2;
    }

    void scorePointFor(Player player) {
        score.put(player, getPointsFor(player).addOne());
    }


    Points getPointsFor(Player player) {
        return score.get(player);
    }

    String getScore() {
        if (isTied()) {
            return getTiedScore();
        } else {
            return getUntiedScore();
        }
    }

    private boolean isTied() {
        return getPointsFor(player1).equals(getPointsFor(player2));
    }

    private String getTiedScore() {
        if (gameHasReachedDeuceStage()) {
            return "Deuce";
        } else {
            return String.format("%s all", getPointsFor(player1));
        }
    }

    private String getUntiedScore() {
        if (onePlayerHasWonTheGame()) {
            return String.format("Game %s", getPlayerWithMostPoints().getName());
        } else if (gameHasReachedDeuceStage()) {
            return String.format("Advantage %s", getPlayerWithMostPoints().getName());
        } else {
            return String.format("%s - %s", getPointsFor(player1), getPointsFor(player2));
        }
    }

    private boolean onePlayerHasWonTheGame() {
        return hasWonGame(player1) || hasWonGame(player2);
    }

    private boolean hasWonGame(Player player) {
        Player otherPlayer = player.equals(player1) ? player2 : player1;
        return getPointsFor(player).areEnoughForWinningTheGame() && getPointsFor(player).areMoreThan(getPointsFor(otherPlayer).add(NEEDED_DIFFERENCE_FOR_WINNING));
    }


    private boolean gameHasReachedDeuceStage() {
        return getPointsFor(player1).areEnoughForDeuce() && getPointsFor(player2).areEnoughForDeuce();
    }

    private Player getPlayerWithMostPoints() {
        if (getPointsFor(player1).areMoreThan(getPointsFor(player2))) {
            return player1;
        } else {
            return player2;
        }
    }
}
