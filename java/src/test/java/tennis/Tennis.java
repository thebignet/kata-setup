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
	if (playerBBalls == 2) return "love-thirteen";
        if (playerBBalls == 1) return "love-fifteen";
        if (playerABalls == 2) return "thirteen-love";
        if (playerABalls == 1) return "fifteen-love";
        if (playerABalls == 0) return "love-love";
        else throw new RuntimeException("not implemented");
    }
}