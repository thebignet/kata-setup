package tennis;

public class Tennis {
    protected int playerABalls;
    protected int playerBBalls;

    public Tennis() {
    }

    Tennis playerBScores() {
	playerBBalls++;
	if (!inBeginningOfGame()) return new TieBreak(this);
	return this;
    }

    Tennis playerAScores() {
	playerABalls++;
	return this;
    }

    String score() {
	return format(playerABalls, playerBBalls);
    }

    private String format(int unused, int unused2) {
	if (inBeginningOfGame()) {
	    if (playerABalls == 4)
		return "game-A";
	    if (playerBBalls == 4)
		return "game-B";
	    return format(playerABalls) + "-" + format(playerBBalls);
	} else {
	    if (playerABalls - playerBBalls == -2)
		return "game-B";
	    if (playerABalls - playerBBalls == -1)
		return "advantage-B";
	    if (playerABalls - playerBBalls == 1)
		return "advantage-A";
	    if (playerABalls - playerBBalls == 0)
		return "deuce";
	    if (playerABalls - playerBBalls == 2)
		return "game-A";
	    else
		throw new RuntimeException("cant happen");
	}

    }

    private boolean inBeginningOfGame() {
	return playerABalls + playerBBalls < 6;
    }

    private String format(int score) {
	String[] scores = { "love", "fifteen", "thirty", "forty" };
	return scores[score];
    }
}