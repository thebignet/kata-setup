package kata;

import java.util.ArrayList;
import java.util.List;

public class Bowling {

    public int score(List<Frame> frames) {
	frames.add(Frame.NULL_FRAME);
	frames.add(Frame.NULL_FRAME);
	int score = 0;
	for (int i = 0; i < frames.size() -2; i++) {
	    Frame frame = frames.get(i);
	    Frame nextFrame = frames.get(i + 1);
	    Frame secondFrame = frames.get(i + 2);
	    frame.setNext(nextFrame, secondFrame);
	}
	for (int i = 0; i < frames.size() -2; i++) {
	    Frame frame = frames.get(i);
	    score += frame.score();
	}
	return score;
    }

}
