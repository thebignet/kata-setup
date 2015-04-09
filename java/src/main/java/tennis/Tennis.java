package tennis;

public class Tennis {
    private Score scoreA = new Score();
    private int playerBWonBalls;

    public Tennis(int playerAWonBalls, int playerBWonBalls) {
	setPlayerAWonBalls(playerAWonBalls);
	setPlayerBWonBalls(playerBWonBalls);
    }
    
    public Tennis() {
    }

    public Tennis playerBScores() {
	setPlayerBWonBalls(getPlayerBWonBalls() + 1);
	return appropriateState();
    }

    public Tennis playerAScores() {
	setPlayerAWonBalls(getPlayerAWonBalls() + 1);
	return appropriateState();
    }

    public String score() {
	if (getPlayerAWonBalls() == 4)
	    return "game-A";
	if (getPlayerBWonBalls() == 4)
	    return "game-B";
	return numericScore(getPlayerAWonBalls()) + "-" + numericScore(getPlayerBWonBalls());
    }
    
    private Tennis appropriateState() {
	return inTieBreak() ? new TieBreak(this) : this;
    }
    
    private boolean inTieBreak() {
	return getPlayerAWonBalls() + getPlayerBWonBalls() >= 6;
    }

    private String numericScore(int score) {
	String[] scores = { "love", "fifteen", "thirty", "forty" };
	return scores[score];
    }

    public int getPlayerAWonBalls() {
	return scoreA.getPlayerAWonBalls();
    }

    public void setPlayerAWonBalls(int playerAWonBalls) {
	this.scoreA.setPlayerAWonBalls(playerAWonBalls);
    }

    public int getPlayerBWonBalls() {
	return playerBWonBalls;
    }

    public void setPlayerBWonBalls(int playerBWonBalls) {
	this.playerBWonBalls = playerBWonBalls;
    }
}