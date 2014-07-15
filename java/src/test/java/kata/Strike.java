package kata;

public class Strike implements Frame {

    private Frame nextFrame;
    private Frame secondFrame;

    @Override
    public int score() {
	int nextFrameScore = 0;
	nextFrameScore = this.nextFrame.nonRecursiveScore();
	return nextFrameScore + 10;
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
    public int nonRecursiveScore() {
	if (nextFrame instanceof Strike) {
	    return 10 + nextFrame.getFirst();
	}
	return 10;
    }

}
