package tennis;

import java.util.HashMap;
import java.util.Map;

public class Points implements Comparable<Points> {
    private static final int MIN_POINTS_FOR_DEUCE = 3;
    private static final int MIN_POINTS_FOR_WINNING = 4;
    private static final Map<Integer, String> textByCount = new HashMap<Integer, String>() {{
        put(0, "Love");
        put(1, "Fifteen");
        put(2, "Thirty");
        put(3, "Forty");
    }};
    int count;

    Points addOne() {
        this.count++;
        return this;
    }

    Points add(int i) {
        this.count += i;
        return this;
    }

    boolean areEnoughForWinningTheGame() {
        return count >= MIN_POINTS_FOR_WINNING;
    }

    boolean areEnoughForDeuce() {
        return count >= MIN_POINTS_FOR_DEUCE;
    }

    boolean areMoreThan(Points other) {
        return this.compareTo(other) > 0;
    }


    @Override
    public String toString() {
        return textByCount.get(count);
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof Points) {
            Points that = (Points) other;
            return this.count == that.count;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return count;
    }

    @Override
    public int compareTo(Points other) {
        return (this.count < other.count ? -1 : (this.count == other.count ? 0 : 1));
    }
}
