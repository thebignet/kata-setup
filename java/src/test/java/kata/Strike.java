package kata;

public class Strike implements Frame {

    private Frame nextFrame;

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
    public void setNext(Frame nextFrame) {
	this.nextFrame = nextFrame;
	
    }

    @Override
    public int nextTwoBalls() {
	return 10 + nextFrame.getFirst();
    }

}
