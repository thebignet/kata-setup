package kata;

import java.util.List;

public class Bowling {
    private static final Frame NULL_FRAME = new NormalFrame(0, 0);
    

    public int score(List<Frame> frames) {
	padFrames(frames);
	decorateWithSubsequentFrames(frames);
	return calculateScore(frames);
    }

    protected int calculateScore(List<Frame> frames) {
	int score = 0;
	for (Frame frame : frames) {
	    score += frame.score();
	}
	return score;
    }

    protected void decorateWithSubsequentFrames(List<Frame> frames) {
	for (int i = 0; i < actualFramesCount(frames); i++) {
	    Frame frame = frames.get(i);
	    Frame nextFrame = frames.get(i + 1);
	    frame.setNext(nextFrame);
	}
    }

    protected void padFrames(List<Frame> frames) {
	frames.add(NULL_FRAME);
	frames.add(NULL_FRAME);
    }

    protected int actualFramesCount(List<Frame> frames) {
	return frames.size() -2;
    }

}
