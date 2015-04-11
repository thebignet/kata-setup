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
        String[] scores = {"not used", "fifteen", "thirty", "forty"};
        return scores[wonBalls];
    }

    public int getWonBalls() {
        return wonBalls;
    }
}