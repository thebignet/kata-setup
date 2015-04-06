package tennis;

public class Tennis {
    protected int playerABalls;
    protected int playerBBalls;

    public Tennis playerBScores() {
	playerBBalls++;
	return appropriateState();
    }

    public Tennis playerAScores() {
	playerABalls++;
	return appropriateState();
    }

    public String score() {
	if (playerABalls == 4)
	    return "game-A";
	if (playerBBalls == 4)
	    return "game-B";
	return numericScore(playerABalls) + "-" + numericScore(playerBBalls);
    }
    
    private Tennis appropriateState() {
	if (inTieBreak()) return new TieBreak(this);
	return this;
    }
    
    private boolean inTieBreak() {
	return playerABalls + playerBBalls >= 6;
    }

    private String numericScore(int score) {
	String[] scores = { "love", "fifteen", "thirty", "forty" };
	return scores[score];
    }
}