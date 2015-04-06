package tennis;

public class Tennis {
    private int playerABalls;
    private int playerBBalls;

    public Tennis() {
    }

    void playerBScores() {
        playerBBalls++;
    }

    void playerAScores() {
        playerABalls++;
    }

    String score() {
	if (playerBBalls == 2) return format(0, 2);
        if (playerBBalls == 1) return format(0, 1);
        
        if (playerABalls == 2) return format(2, 0);
        if (playerABalls == 1) return format(1, 0);
        if (playerABalls == 0) return format(0, 0);
        
        else throw new RuntimeException("not implemented");
    }

    private String format(int aScore, int bScore) {
	return format(aScore) + "-" + format(bScore);
    }

    private String format(int score) {
	if (score == 2) return "thirty" ;
	if (score == 1) return "fifteen" ;
	return "love";
    }
}