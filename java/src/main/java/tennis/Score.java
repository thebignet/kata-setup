package tennis;

public class Score {
    private static final String SEPARATOR = "-";
    private int wonBalls;
    private String name;

    public Score(String name) {
	this.name = name;
    }

    public int getWonBalls() {
	return wonBalls;
    }

    public void setPlayerAWonBalls(int playerAWonBalls) {
	this.wonBalls = playerAWonBalls;
    }

    void scoreOneBall() {
        setPlayerAWonBalls(getWonBalls() + 1);
    }

    boolean wonGameBeforeTieBreak() {
        return getWonBalls() == 4;
    }

    public String wonGame() {
	return "game" + SEPARATOR + name;
    }

    String pronounce() {
        String[] scores = { "love", "fifteen", "thirty", "forty" };
        return scores[getWonBalls()];
    }
}