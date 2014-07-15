package kata;

import java.util.List;

public class Bowling {

    public int score(List<Frame> frames) {
	frames.add(Frame.NULL_FRAME);
	int score = 0;
	for (int i = 0; i < frames.size() -1; i++) {
	    Frame frame = frames.get(i);
	    Frame nextFrame = frames.get(i + 1);
	    score += frame.score(nextFrame);
	}
	return score;
    }

}
