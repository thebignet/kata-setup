package tennis;

public class Tennis {
    protected Score scoreA = new Score();
    protected Score scoreB = new Score();

    public Tennis(int playerAWonBalls, int playerBWonBalls) {
	scoreA.setPlayerAWonBalls(playerAWonBalls);
	scoreB.setPlayerAWonBalls(playerBWonBalls);
    }
    
    public Tennis() {
    }

    public Tennis playerAScores() {
	scoreA.scoreOneBall();
	return appropriateState();
    }
    
    public Tennis playerBScores() {
	scoreB.scoreOneBall();
	return appropriateState();
    }

    public String score() {
	if (scoreA.wonGameBeforeTieBreak())
	    return "game-A";
	if (scoreB.wonGameBeforeTieBreak())
	    return "game-B";
	return numericScore(scoreA.getPlayerAWonBalls()) + "-" + numericScore(scoreB.getPlayerAWonBalls());
    }

    private Tennis appropriateState() {
	return inTieBreak() ? new TieBreak(this) : this;
    }
    
    private boolean inTieBreak() {
	return scoreA.getPlayerAWonBalls() + scoreB.getPlayerAWonBalls() >= 6;
    }

    private String numericScore(int score) {
	String[] scores = { "love", "fifteen", "thirty", "forty" };
	return scores[score];
    }
}