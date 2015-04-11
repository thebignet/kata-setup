package tennis;

public class PlayerScore {
    private int wonBalls;

    public PlayerScore(int wonBalls) {
        this.wonBalls = wonBalls;
    }

    public PlayerScore() {
    }

    PlayerScore playerScores() {
        wonBalls++;
        return this;
    }

    String format() {
        return "forty";
    }

    public int getWonBalls() {
        return wonBalls;
    }

    boolean inTieBreak(PlayerScore otherScore) {
        return getWonBalls() + otherScore.getWonBalls() >= 6;
    }
}