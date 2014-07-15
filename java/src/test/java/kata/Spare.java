package kata;

public class Spare implements Frame {

    private int first;
    private Frame nextFrame;

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
    public void setNext(Frame nextFrame) {
	this.nextFrame = nextFrame;
    }

    @Override
    public int nextTwoBalls() {
	return 10;
    }

}