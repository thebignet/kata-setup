package kata;

public class NormalFrame implements Frame {

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
    public void setNext(Frame nextFrame, Frame secondFrame) {
    }

    @Override
    public int nonRecursiveScore() {
	return score();
    }

}