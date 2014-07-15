package kata;

import java.util.List;

public class Bowling {
    private static final Frame NULL_FRAME = new NormalFrame(0, 0);
    private List<Frame> frames;
    

    public Bowling(List<Frame> frames) {
	this.frames = frames;
	padFrames();
	decorateWithSubsequentFrames();
    }

    public int score() {
	int score = 0;
	for (Frame frame : frames) {
	    score += frame.score();
	}
	return score;
    }

    private void decorateWithSubsequentFrames() {
	for (int i = 0; i < actualFramesCount(); i++) {
	    Frame frame = frames.get(i);
	    Frame nextFrame = frames.get(i + 1);
	    frame.setNext(nextFrame);
	}
    }

    private void padFrames() {
	frames.add(NULL_FRAME);
	frames.add(NULL_FRAME);
    }

    private int actualFramesCount() {
	return frames.size() -2;
    }

}
