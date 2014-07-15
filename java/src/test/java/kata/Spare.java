package kata;

public class Spare implements Frame {

    private int first;

    public Spare(int first) {
        this.first = first;
    }

    @Override
    public int score(Frame nextFrame) {
        int nextFrameScore = 0;
        nextFrameScore = nextFrame.getFirst();
        return nextFrameScore + 10;
    }

    @Override
    public int getFirst() {
        return first;
    }

}