package kata;


public class Bowling {

    public int score(Integer...balls) {
	int score = 0;
	for (int i = 0; i < balls.length; i++) {
	    score += balls[i];
	}
	if (balls.length > 1 && balls[0] + balls[1] == 10)
	    score += balls[2];
	if (balls.length > 4 && balls[2] + balls[3] == 10)
	    score += balls[4];
	return score;
    }

}
