package tennis;

public class Tennis {
    protected Score scoreA = new Score.Love("A");
    protected Score scoreB = new Score("B");

    public Tennis(Score playerAWonBalls, Score playerBWonBalls) {
	scoreA = playerAWonBalls;
	scoreB = playerBWonBalls;
    }
    
    public Tennis() {
    }

    public Tennis playerAScores() {
	scoreA = scoreA.scoreOneBall();
	return appropriateState();
    }
    
    public Tennis playerBScores() {
	scoreB = scoreB.scoreOneBall();
	return appropriateState();
    }

    public String score() {
	if (scoreA.wonGameBeforeTieBreak())
	    return scoreA.wonGame();
	if (scoreB.wonGameBeforeTieBreak())
	    return scoreB.wonGame();
	return pronounce();
    }

    private Tennis appropriateState() {
	return inTieBreak() ? new TieBreak(this) : this;
    }
    
    private boolean inTieBreak() {
	return scoreA.getWonBalls() + scoreB.getWonBalls() >= 6;
    }

    private String pronounce() {
        return scoreA.pronounce() + 
        	"-" + scoreB.pronounce();
    }
}