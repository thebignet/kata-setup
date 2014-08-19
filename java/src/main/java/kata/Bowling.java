package kata;

import static java.util.Arrays.asList;

import java.util.ArrayList;
import java.util.List;

import kata.frames.LinkedFrame;
import kata.frames.NormalFrame;

public class Bowling {
    private static final int FRAMES_IN_A_GAME = 10;
    public static final LinkedFrame NULL_FRAME = new NormalFrame(0, 0);
    private List<LinkedFrame> frames;

    private Bowling(List<LinkedFrame> frames) {
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
	    LinkedFrame frame = frames.get(i);
	    LinkedFrame nextFrame = frames.get(i + 1);
	    frame.setNext(nextFrame);
	}
    }

    public static Bowling bowling(LinkedFrame... frames) {
        List<LinkedFrame> listOfFrames = new ArrayList<LinkedFrame>(asList(frames));
        for (int i = frames.length; i <= FRAMES_IN_A_GAME; i++) {
            listOfFrames.add(NULL_FRAME);
        }
        return new Bowling(listOfFrames);
    }

}
