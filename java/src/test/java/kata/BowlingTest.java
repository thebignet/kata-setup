package kata;

import static org.fest.assertions.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.Arrays;

import org.junit.Test;

public class BowlingTest {
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

    Bowling bowling = new Bowling();

    @Test
    public void score() {
	assertThat(score(f(0, 0))).isEqualTo(0);
	assertThat(score(f(1, 1))).isEqualTo(2);
	assertThat(score(f(2, 3), f(1, 2))).isEqualTo(5 + 3);
    }

    private int score(Frame... frames) {
	return bowling.score(Arrays.asList(frames));
    }

    private Frame f(int first, int second) {
	return new NormalFrame(first, second);
    }
}
