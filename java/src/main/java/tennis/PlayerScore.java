package tennis;

public class PlayerScore {
    int playerABalls;

    public PlayerScore() {
    }

    Tennis playerScores() {
        playerABalls++;
        return null;
    }

    String format(int score) {
        String[] scores = {"love", "fifteen", "thirty", "forty"};
        return scores[score];
    }
}