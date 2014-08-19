package kata.frames;

import kata.Frame;

public class Spare extends BaseFrame {

    private int first;
    private BaseFrame nextFrame;

    public Spare(int first) {
        this.first = first;
    }

    @Override
    public int score() {
        int nextFrameScore = 0;
        nextFrameScore = nextFrame.getFirst();
        return nextFrameScore + 10;
    }

    @Override
    public int getFirst() {
        return first;
    }

    @Override
    public void setNext(BaseFrame nextFrame) {
	this.nextFrame = nextFrame;
    }

    @Override
    public int nextTwoBalls() {
	return 10;
    }

}