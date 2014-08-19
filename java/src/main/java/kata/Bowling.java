package kata;

import static java.util.Arrays.asList;

import java.util.ArrayList;
import java.util.List;

import kata.Frame.BaseFrame;

public class Bowling {
    private static final int FRAMES_IN_A_GAME = 10;
    public static final BaseFrame NULL_FRAME = new NormalFrame(0, 0);
    private List<BaseFrame> frames;

    private Bowling(List<BaseFrame> frames) {
	this.frames = frames;
	lastFrameMustHaveNextFrame();
	makeFramesAwareOfTheirNextFrame();
    }

    public int score() {
	int score = 0;
	for (Frame frame : frames) {
	    score += frame.score();
	}
	return score;
    }

    private void lastFrameMustHaveNextFrame() {
	frames.add(NULL_FRAME);
    }

    private void makeFramesAwareOfTheirNextFrame() {
	for (int i = 0; i < FRAMES_IN_A_GAME; i++) {
	    BaseFrame frame = frames.get(i);
	    BaseFrame nextFrame = frames.get(i + 1);
	    frame.setNext(nextFrame);
	}
    }

    public static Bowling bowling(BaseFrame... frames) {
        List<BaseFrame> listOfFrames = new ArrayList<BaseFrame>(asList(frames));
        for (int i = frames.length; i <= FRAMES_IN_A_GAME; i++) {
            listOfFrames.add(NULL_FRAME);
        }
        return new Bowling(listOfFrames);
    }

}
