package kata;

import static java.util.Arrays.asList;
import static org.fest.assertions.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class BowlingTest {
    Bowling bowling = new Bowling();

    @Test
    public void score() {
	assertThat(score(f(0, 0))).isEqualTo(0);
	assertThat(score(f(1, 1))).isEqualTo(2);
	assertThat(score(f(2, 3), f(1, 2))).isEqualTo(5 + 3);

	assertThat(score(f(9, 1), f(2, 3))).isEqualTo(12 + 5);
    }

    private int score(Frame... frames) {
	return bowling.score(new ArrayList<Frame>(asList(frames)));
    }

    private Frame f(int first, int second) {
	return new NormalFrame(first, second);
    }
}
