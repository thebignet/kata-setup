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
	if (inBeginningOfGame(aScore, bScore)) {
	    if (aScore == 4)
		return "game-A";
	    if (bScore == 4)
		return "game-B";
	    return format(aScore) + "-" + format(bScore);
	} else {
	    if (aScore - bScore == -2)
		return "game-B";
	    if (aScore - bScore == -1)
		return "advantage-B";
	    if (aScore - bScore == 1)
		return "advantage-A";
	    if (aScore - bScore == 0)
		return "deuce";
	    if (aScore - bScore == 2)
		return "game-A";
	    else
		throw new RuntimeException("cant happen");
	}

    }

    private boolean inBeginningOfGame(int aScore, int bScore) {
	return aScore + bScore < 6;
    }

    private String format(int score) {
	String[] scores = { "love", "fifteen", "thirty", "forty" };
	return scores[score];
    }
}