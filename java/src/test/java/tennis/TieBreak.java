package tennis;

public class TieBreak extends Tennis {

    public TieBreak(Tennis tennis) {
	this.playerABalls = tennis.playerABalls;
	this.playerBBalls = tennis.playerBBalls;
    }

    @Override
    public String score() {
	if (playerABalls - playerBBalls == -2)
	    return "game-B";
	if (playerABalls - playerBBalls == -1)
	    return "advantage-B";
	if (playerABalls - playerBBalls == 1)
	    return "advantage-A";
	if (playerABalls - playerBBalls == 0)
	    return "deuce";
	if (playerABalls - playerBBalls == 2)
	    return "game-A";
	else
	    throw new RuntimeException("cant happen");
    }

}
