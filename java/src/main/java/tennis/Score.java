package tennis;

public class Score {
    private int playerAWonBalls;

    public Score() {
    }

    public int getPlayerAWonBalls() {
	return playerAWonBalls;
    }

    public void setPlayerAWonBalls(int playerAWonBalls) {
	this.playerAWonBalls = playerAWonBalls;
    }

    void scoreOneBall() {
        setPlayerAWonBalls(getPlayerAWonBalls() + 1);
    }

    boolean wonGameBeforeTieBreak() {
        return getPlayerAWonBalls() == 4;
    }
}