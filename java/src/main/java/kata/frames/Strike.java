package kata.frames;

import kata.Frame;

public class Strike extends BaseFrame {

    private BaseFrame nextFrame;

    @Override
    public int score() {
	int nextTwoBalls = nextFrame.nextTwoBalls();
	return nextTwoBalls + 10;
    }

    @Override
    public int getFirst() {
	return 10;
    }

    @Override
    public void setNext(BaseFrame nextFrame) {
	this.nextFrame = nextFrame;
	
    }

    @Override
    public int nextTwoBalls() {
	return 10 + nextFrame.getFirst();
    }

}
