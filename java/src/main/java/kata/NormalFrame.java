package kata;

public class NormalFrame implements Frame {

    private int first;
    private int second;

    public NormalFrame(int first, int second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public int score(Frame nextFrame) {
	int nextFrameScore = 0;
	if (first == 10) {
	    nextFrameScore = nextFrame.score(NULL_FRAME);
	}
	else if (first + second == 10) {
	    nextFrameScore = nextFrame.getFirst();
	}
	return nextFrameScore + first + second;
    }

    @Override
    public int getFirst() {
 	return first;
    }

}