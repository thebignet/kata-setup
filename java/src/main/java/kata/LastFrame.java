package kata;

import kata.Frame.BaseFrame;

public final class LastFrame extends BaseFrame {
    private final int second;
    private final int first;
    private final int third;

    public LastFrame(int first, int second, int third) {
        this.second = second;
        this.first = first;
        this.third = third;
    }

    public LastFrame(int first, int second) {
        this(first, second, 0);
    }

    @Override
    public int score() {
        return first + second + third;
    }

    @Override
    protected int nextTwoBalls() {
        return second + third;
    }

    @Override
    protected int getFirst() {
        return first;
    }

    @Override
    protected void setNext(BaseFrame nextFrame) {
        // none
    }
}