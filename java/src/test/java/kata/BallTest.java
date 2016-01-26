package kata;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.within;

import org.junit.Test;

public class BallTest {

  @Test
  public void itRollsForAGivenAmountOfTime() throws Exception {
    int timeInMilliseconds = 70;
    Ball ball = new Ball(timeInMilliseconds);

    double before = System.currentTimeMillis();
    ball.roll();
    double after = System.currentTimeMillis();

    assertThat(after - before).isCloseTo(70, within(30d));

  }
}
