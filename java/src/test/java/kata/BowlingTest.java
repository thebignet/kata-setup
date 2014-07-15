package kata;

import static java.util.Arrays.asList;
import static org.fest.assertions.api.Assertions.assertThat;

import java.util.ArrayList;

import org.junit.Test;

public class BowlingTest {

    @Test
    public void score() {
	assertThat(score(f(0, 0))).isEqualTo(0);
	assertThat(score(f(1, 1))).isEqualTo(2);
	assertThat(score(f(2, 3), f(1, 2))).isEqualTo(5 + 3);

	assertThat(score(spare(9), f(2, 3))).isEqualTo(12 + 5);
	
	assertThat(score(strike(), f(2, 3))).isEqualTo(15 + 5);
	assertThat(score(strike(), spare(7))).isEqualTo(20 + 10);
	assertThat(score(strike(), strike(), strike())).isEqualTo(30 + 20 + 10);
	assertThat(score(strike(), strike(), strike(), 
		strike(), strike(), strike(),
		strike(), strike(), strike(),
		strike(), strike())).isEqualTo(300);
	
	assertThat(score(strike(), spare(8), f(2, 3))).isEqualTo(20 + 12 + 5);
    }

    private Frame strike() {
	return new Strike();
    }

    private Frame spare(int first) {
	return new Spare(first);
    }

    private int score(Frame... frames) {
	Bowling bowling = new Bowling(new ArrayList<Frame>(asList(frames)));
	return bowling.score();
    }

    private Frame f(int first, int second) {
	return new NormalFrame(first, second);
    }
}
