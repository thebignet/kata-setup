package kata;

public class Strike implements Frame {

    private Frame nextFrame;
    private Frame secondFrame;

    @Override
    public int score() {
	int nextTwoBalls = 0;
	nextTwoBalls = this.nextFrame.nextTwoBalls();
	return nextTwoBalls + 10;
    }

    @Override
    public int getFirst() {
	return 10;
    }

    @Override
    public void setNext(Frame nextFrame, Frame secondFrame) {
	this.nextFrame = nextFrame;
	this.secondFrame = secondFrame;
	
    }

    @Override
    public int nextTwoBalls() {
	return 10 + nextFrame.getFirst();
    }

}
