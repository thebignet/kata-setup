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

    public Tennis playerBScores() {
	scoreB.setPlayerAWonBalls(scoreB.getPlayerAWonBalls() + 1);
	return appropriateState();
    }

    public Tennis playerAScores() {
	scoreA.setPlayerAWonBalls(scoreA.getPlayerAWonBalls() + 1);
	return appropriateState();
    }

    public String score() {
	if (scoreA.getPlayerAWonBalls() == 4)
	    return "game-A";
	if (scoreB.getPlayerAWonBalls() == 4)
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