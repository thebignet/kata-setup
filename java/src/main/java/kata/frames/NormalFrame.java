package kata.frames;

public class NormalFrame extends BaseFrame {

    private int first;
    private int second;

    public NormalFrame(int first, int second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public int score() {
	return first + second;
    }

    @Override
    public int getFirst() {
 	return first;
    }

    @Override
    public int nextTwoBalls() {
	return score();
    }

}