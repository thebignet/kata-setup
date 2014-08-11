package kata;

import java.util.List;

public class Bowling {
    private static final Frame NULL_FRAME = new NormalFrame(0, 0);
    private List<Frame> frames;

    public Bowling(List<Frame> frames) {
	this.frames = frames;
	lastFrameMustHaveNextFrame();
	makeFramesAwareOfTheirNextFrame();
    }

    public int score() {
	int score = 0;
	for (int i = 0; i < min(frames.size(), 10); i++) {
	    Frame frame = frames.get(i);
	    score += frame.score();
	}
	return score;
    }

    private int min(int i, int j) {
	return i < j ? i : j;
    }

    private void lastFrameMustHaveNextFrame() {
	frames.add(NULL_FRAME);
    }

    private void makeFramesAwareOfTheirNextFrame() {
	for (int i = 0; i < actualFramesCount(); i++) {
	    Frame frame = frames.get(i);
	    Frame nextFrame = frames.get(i + 1);
	    frame.setNext(nextFrame);
	}
    }

    private int actualFramesCount() {
	return frames.size() - 1;
    }

}
