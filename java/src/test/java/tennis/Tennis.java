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
	if (!inBeginningOfGame()) return new TieBreak(this);
	return this;
    }

    String score() {
	return format();
    }

    protected String format() {
	if (playerABalls == 4)
	    return "game-A";
	if (playerBBalls == 4)
	    return "game-B";
	return format(playerABalls) + "-" + format(playerBBalls);

    }

    private boolean inBeginningOfGame() {
	return playerABalls + playerBBalls < 6;
    }

    protected String format(int score) {
	String[] scores = { "love", "fifteen", "thirty", "forty" };
	return scores[score];
    }
}