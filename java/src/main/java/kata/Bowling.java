package kata;

import java.util.LinkedList;
import java.util.List;


public class Bowling {

    public int score(List<Frame> frames) {
	LinkedList<Frame> fs = new LinkedList<Frame>(frames);
	fs.add(Frame.NULL_FRAME);
	frames.add(Frame.NULL_FRAME);
	int score = 0;
	for (Frame frame : fs) {
	    Frame nextFrame = frames.get(1);
	    score += frame.score(nextFrame );
	}
	return score;
    }

}
