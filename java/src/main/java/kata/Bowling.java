package kata;

import java.util.List;


public class Bowling {

    public int score(List<Frame> frames) {
	int score = 0;
	for (Frame frame : frames) {
	    score += frame.score();
	}
	return score;
    }

}
