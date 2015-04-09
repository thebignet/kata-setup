package tennis;

public class Score {
    private static final String SEPARATOR = "-";
    protected int wonBalls;
    protected String name;

    public Score(String name) {
	this.name = name;
    }

    public int getWonBalls() {
	return wonBalls;
    }

    public void setPlayerAWonBalls(int playerAWonBalls) {
	this.wonBalls = playerAWonBalls;
    }

    Score scoreOneBall() {
        setPlayerAWonBalls(getWonBalls() + 1);
        return this;
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
    
    public static class Love extends Score  {
	public Love(String name) {
	    super(name);
	}

	@Override
	Score scoreOneBall() {
	    Score score = new Score(name);
	    score.wonBalls++;
	    return score;
	    
	}
	
	@Override
	String pronounce() {
	    return "love";
	}
    }
}