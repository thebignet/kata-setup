package kata;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import kata.Roulette.Result.Color;
import kata.Roulette.RouletteException;

import org.junit.Test;

public class RouletteTest {
  private Randomizer randomizer = mock(Randomizer.class);
  private Ball ball = mock(Ball.class);

  @Test
  public void itWaitsForTheBallToStop() {
    Roulette roulette = new Roulette(ball, randomizer);

    roulette.playGame();

    verify(ball).roll();
  }

  @Test()
  public void theResultIsAlwaysBetween00and36() throws Exception {
    assertNumberResult(0, "0");
    assertNumberResult(12, "12");
    assertNumberResult(36, "36");
    assertNumberResult(37, "00");
  }

  @Test
  public void theColorOf0and00IsGreen() throws Exception {
    assertCorlorResult(0, Color.GREEN);
    assertCorlorResult(37, Color.GREEN);
  }

  @Test
  public void theColorOfEvenNumbersIsBlack() throws Exception {
    assertCorlorResult(2, Color.BLACK);
    assertCorlorResult(14, Color.BLACK);
    assertCorlorResult(36, Color.BLACK);
  }

  @Test
  public void theColorOfOddNumbersIsRed() throws Exception {
    assertCorlorResult(1, Color.RED);
    assertCorlorResult(7, Color.RED);
    assertCorlorResult(35, Color.RED);
  }

  @Test(expected = RouletteException.class)
  public void itThrowsExceptionWhenTheRandomizerIsGreaterThan37()
      throws Exception {
    Randomizer randomizer = mock(Randomizer.class);
    when(randomizer.getRouletteResult()).thenReturn(38);
    Roulette roulette = new Roulette(ball, randomizer);

    roulette.playGame();

	  // then exception
  }
  @Test(expected = RouletteException.class)
  public void itThrowsExceptionWhenTheRandomizerIsLesserThan0()
      throws Exception {
    Randomizer randomizer = mock(Randomizer.class);
    when(randomizer.getRouletteResult()).thenReturn(-1);
    Roulette roulette = new Roulette(ball, randomizer);

    roulette.playGame();

	  // then exception
  }

  private void assertCorlorResult(int randomizerValue, Color expectedColor) {
    Randomizer randomizer = mock(Randomizer.class);
    when(randomizer.getRouletteResult()).thenReturn(randomizerValue);
    Roulette roulette = new Roulette(ball, randomizer);

    Roulette.Result actualResult = roulette.playGame();

    assertEquals(expectedColor, actualResult.getColor());

  }

  private void assertNumberResult(int randomizerValue, String expectedNumber) {
    Randomizer randomizer = mock(Randomizer.class);
    when(randomizer.getRouletteResult()).thenReturn(randomizerValue);
    Roulette roulette = new Roulette(ball, randomizer);

    Roulette.Result actualResult = roulette.playGame();

    assertEquals(expectedNumber, actualResult.getNumber());
  }
}
