package kata;

public class Strike implements Frame {

    @Override
    public int score(Frame nextFrame) {
	int nextFrameScore = 0;
	nextFrameScore = nextFrame.score(NULL_FRAME);
	return nextFrameScore + 10;
    }

    @Override
    public int getFirst() {
	return 10;
    }

}
