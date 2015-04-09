package tennis;

public class Score {
    private int playerAWonBalls;

    public Score() {
    }

    public int getWonBalls() {
	return playerAWonBalls;
    }

    public void setPlayerAWonBalls(int playerAWonBalls) {
	this.playerAWonBalls = playerAWonBalls;
    }

    void scoreOneBall() {
        setPlayerAWonBalls(getWonBalls() + 1);
    }

    boolean wonGameBeforeTieBreak() {
        return getWonBalls() == 4;
    }
}