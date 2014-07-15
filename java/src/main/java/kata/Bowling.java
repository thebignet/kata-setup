package kata;

import java.util.List;


public class Bowling {

    public int score(List<Frame> frames) {
	frames.add(Frame.NULL_FRAME);
	int score = 0;
	for (Frame frame : frames) {
	    Frame nextFrame = frames.get(1);
	    score += frame.score(nextFrame );
	}
	return score;
    }

}
