package kata;

import static kata.Bowling.NULL_FRAME;
import static org.fest.assertions.api.Assertions.assertThat;
import kata.Frame.BaseFrame;

import org.junit.Test;

public class BowlingTest {

    public static final class LastFrame extends BaseFrame {
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

    @Test
    public void score() {
	assertThat(score(f(0, 0))).isEqualTo(0);
	assertThat(score(f(1, 1))).isEqualTo(2);
	assertThat(score(f(2, 3), f(1, 2))).isEqualTo(5 + 3);

	assertThat(score(spare(9), f(2, 3))).isEqualTo(12 + 5);
	
	assertThat(score(strike(), f(2, 3))).isEqualTo(15 + 5);
	assertThat(score(strike(), spare(7))).isEqualTo(20 + 10);
	assertThat(score(strike(), strike(), strike())).isEqualTo(30 + 20 + 10);
	assertThat(scoreForPerfectGame()).isEqualTo(300); 
	
	assertThat(score(strike(), spare(8), f(2, 3))).isEqualTo(20 + 12 + 5);

	assertThat(score(NULL_FRAME, NULL_FRAME, NULL_FRAME,
		NULL_FRAME, NULL_FRAME, NULL_FRAME,
		lastframe(3, 4))).isEqualTo(7);
    }


    protected int scoreForPerfectGame() {
	return score(strike(), strike(), strike(), 
		strike(), strike(), strike(),
		strike(), strike(), strike(),
		lastframe(10, 10, 10));
    }

    private BaseFrame lastframe(int first, int second) {
	return new LastFrame(first, second);
    }
    
    private BaseFrame lastframe(final int first, final int second, final int third) {
	return new LastFrame(first, second, third);
    }

    private BaseFrame strike() {
	return new Strike();
    }

    private BaseFrame spare(int first) {
	return new Spare(first);
    }

    private int score(BaseFrame...frames) {
	Bowling bowling = Bowling.bowling(frames);
	return bowling.score();
    }

    private BaseFrame f(int first, int second) {
	return new NormalFrame(first, second);
    }
}
