package kata.frames;

public class Strike extends BaseFrame {

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
    public int nextTwoBalls() {
	return 10 + nextFrame.getFirst();
    }

}
