package kata;


public class Bowling {

    public int score(Integer...balls) {
	int score = 0;
	for (int i = 0; i < balls.length; i++) {
	    score += balls[i];
	}
	for (int i = 1; i < balls.length - 1; i+=2) {
	    if (balls[i-1] == 10)
		score += balls[i+1] + balls[i+2];
	    else if (balls[i-1] + balls[i] == 10)
		score += balls[i+1];
	}
	return score;
    }

}
