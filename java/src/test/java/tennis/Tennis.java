package tennis;

public class Tennis {
    private int playerABalls;
    private int playerBBalls;

    public Tennis() {
    }

    public int getPlayerABalls() {
	return playerABalls;
    }

    public void setPlayerABalls(int playerABalls) {
	this.playerABalls = playerABalls;
    }

    public int getPlayerBBalls() {
	return playerBBalls;
    }

    public void setPlayerBBalls(int playerBBalls) {
	this.playerBBalls = playerBBalls;
    }

    void playerBScores() {
        setPlayerBBalls(getPlayerBBalls() + 1);
    }

    void playerAScores() {
        setPlayerABalls(getPlayerABalls() + 1);
    }

    String score() {
        if (getPlayerBBalls() == 1) return "love-fifteen";
        if (getPlayerABalls() == 2) return "thirteen-love";
        if (getPlayerABalls() == 1) return "fifteen-love";
        if (getPlayerABalls() == 0) return "love-love";
        else throw new RuntimeException("not implemented");
    }
}