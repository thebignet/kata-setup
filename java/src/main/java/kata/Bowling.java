package kata;

import static java.util.Arrays.asList;

import java.util.ArrayList;
import java.util.List;

public class Bowling {
    private static final int FRAMES_IN_A_GAME = 10;
    private static final Frame NULL_FRAME = new NormalFrame(0, 0);
    private List<Frame> frames;

    private Bowling(List<Frame> frames) {
	this.frames = frames;
	lastFrameMustHaveNextFrame();
	makeFramesAwareOfTheirNextFrame();
    }

    public int score() {
	int score = 0;
	for (int i = 0; i < FRAMES_IN_A_GAME; i++) {
	    Frame frame = frames.get(i);
	    score += frame.score();
	}
	return score;
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

    public static Bowling bowling(Frame... frames) {
        ArrayList<Frame> listOfFrames = new ArrayList<Frame>(asList(frames));
        for (int i = frames.length; i <= FRAMES_IN_A_GAME; i++) {
            listOfFrames.add(NULL_FRAME);
        }
        return new Bowling(listOfFrames);
    }

}
