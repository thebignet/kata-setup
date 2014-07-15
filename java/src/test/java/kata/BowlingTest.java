package kata;

import static java.util.Arrays.asList;
import static org.fest.assertions.api.Assertions.assertThat;

import java.util.ArrayList;

import org.junit.Test;

public class BowlingTest {
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

    Bowling bowling = new Bowling();

    @Test
    public void score() {
	assertThat(score(f(0, 0))).isEqualTo(0);
	assertThat(score(f(1, 1))).isEqualTo(2);
	assertThat(score(f(2, 3), f(1, 2))).isEqualTo(5 + 3);

	assertThat(score(spare(9), f(2, 3))).isEqualTo(12 + 5);

	assertThat(score(f(10, 0), f(2, 3))).isEqualTo(15 + 5);
    }

    private Frame spare(int first) {
	// TODO Auto-generated method stub
	return new Spare(first);
    }

    private int score(Frame... frames) {
	return bowling.score(new ArrayList<Frame>(asList(frames)));
    }

    private Frame f(int first, int second) {
	return new NormalFrame(first, second);
    }
}
