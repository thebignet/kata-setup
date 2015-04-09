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
	return formatScore();
    }

    private String formatScore() {
	/*
	 * [playerAScore, diff ]
	 * 
	 * [scoreA, scoreB]
	 * [0, 1], "love-fifteen"
	 * [4, 0], "game-A"
	 * [3, 3], "deuce"
	 * 
	 * [3, 3], "deuce"
	 * [4, 3], "advantage-A"
	 * 
	 * [4, 4], "deuce"
	 * [123, 122], "advantage-A"
	 */
	return numericScore(scoreA) + 
		"-" + numericScore(scoreB);
    }

    private Tennis appropriateState() {
	return inTieBreak() ? new TieBreak(this) : this;
    }
    
    private boolean inTieBreak() {
	return scoreA.getWonBalls() + scoreB.getWonBalls() >= 6;
    }

    private String numericScore(Score score) {
	String[] scores = { "love", "fifteen", "thirty", "forty" };
	return scores[score.getWonBalls()];
    }
}