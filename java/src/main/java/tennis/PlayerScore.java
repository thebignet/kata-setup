package tennis;

public class PlayerScore {
    private int wonBalls;

    public PlayerScore() {
    }

    Tennis playerScores() {
        wonBalls++;
        return null;
    }

    String format() {
        String[] scores = {"love", "fifteen", "thirty", "forty"};
        return scores[wonBalls];
    }

    public int getWonBalls() {
        return wonBalls;
    }
}