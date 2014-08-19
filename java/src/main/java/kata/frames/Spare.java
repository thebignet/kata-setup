package kata.frames;

public class Spare extends LinkedFrame {

    private int first;

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
    public int nextTwoBalls() {
	return 10;
    }

}