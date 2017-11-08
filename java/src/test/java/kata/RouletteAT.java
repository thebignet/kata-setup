package kata;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;

import kata.Result.Color;

public class RouletteAT {
  private Randomizer randomizer = mock(Randomizer.class);
  private Ball ball = mock(Ball.class);

  @Test
  public void itWaitsForTheBallToStop() {
    Roulette roulette = new Roulette(ball, randomizer);

    roulette.playGame();

    verify(ball).roll();
  }

  @Test()
  public void itProvidesAResultWithColor() throws Exception {
    Randomizer randomizer1 = mock(Randomizer.class);
    when(randomizer1.getRouletteResult()).thenReturn(0);
    Roulette roulette = new Roulette(ball, randomizer1);

    Result actualResult = roulette.playGame();

    assertEquals("0", actualResult.getNumber());
    assertEquals(Color.GREEN, actualResult.getColor());
  }

}
