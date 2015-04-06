package tennis;

public class Tennis {
    private int playerABalls;
    private int playerBBalls;

    public Tennis() {
    }

    void playerBScores() {
        playerBBalls++;
    }

    void playerAScores() {
        playerABalls++;
    }

    String score() {
	return format(playerABalls, playerBBalls);
    }

    private String format(int aScore, int bScore) {
	if (aScore >= 3 && aScore-bScore == -1) return "advantage-B";
	if (bScore >= 3 && aScore-bScore == 1) return "advantage-A";
	if (aScore >= 3 && aScore - bScore == 0) return "deuce";
	
	if (aScore == 4) return "game-A";
	if (bScore == 4) return "game-B";
	if (bScore == 3 && aScore == 3) return "deuce";
	return format(aScore) + "-" + format(bScore);
    }

    private String format(int score) {
	String[] scores = {"love", "fifteen", "thirty", "forty"};
	return scores[score];
    }
}