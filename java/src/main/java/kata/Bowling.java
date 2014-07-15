package kata;


public class Bowling {

    public int score(Integer...balls) {
	int score = 0;
	for (int i = 0; i < balls.length; i++) {
	    score += balls[i];
	}
	for (int i = 1; i < balls.length - 1; i+=2) {
	    Integer firstBall = balls[i-1];
	    Integer nextBall = balls[i+1];
	    if (firstBall == 10) {
		Integer secondNextBall ;
		if (firstBall == 10 && balls.length> i+3)
		    secondNextBall = balls[i+3];
		else
		    secondNextBall = balls[i+2];
		
		score += nextBall + secondNextBall;
	    } else if (firstBall + balls[i] == 10)
		score += nextBall;
	}
	return score;
    }

}
