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
	return format(playerABalls, playerBBalls);
    }

    private String format(int aScore, int bScore) {
	return format(aScore) + "-" + format(bScore);
    }

    private String format(int score) {
	if (score == 3) return "forty" ;
	if (score == 2) return "thirty" ;
	if (score == 1) return "fifteen" ;
	return "love";
    }
}