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

}