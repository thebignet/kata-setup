package kata;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import kata.Roulette.Result.Color;

import org.junit.Test;

public class RouletteTest {
    Randomizer randomizer = mock(Randomizer.class);
    Ball ball = mock(Ball.class);

    @Test
    public void itWaitsForTheBallToStop() {
        Roulette roulette = new Roulette(ball, randomizer);
        
        roulette.playGame();
        
        verify(ball).roll();
       
    }
    
    @Test() public void 
    theResultIsAlwaysBetween00and36() throws Exception {
	assertRouletteResult(0, "0");
	assertRouletteResult(12, "12");
	assertRouletteResult(36, "36");
	assertRouletteResult(37, "00");
    }
    
    @Test public void 
    theColorOf0and00IsGreen() throws Exception {
	assertCorlorResult(0, Color.GREEN);
	assertCorlorResult(37, Color.GREEN);
    }
    
    @Test public void 
    theColorOfEvenNumbersIsBlack() throws Exception {
	 assertCorlorResult(2, Color.BLACK);
	 assertCorlorResult(14, Color.BLACK);
	 assertCorlorResult(36, Color.BLACK);
    }
    
    @Test public void 
    theColorOfOddNumbersIsRed() throws Exception {
	assertCorlorResult(1, Color.RED);
	assertCorlorResult(7, Color.RED);
	assertCorlorResult(35, Color.RED);
    }

    private void assertCorlorResult(int randomizerValue, Color expectedColor) {	
	Randomizer randomizer = mock(Randomizer.class);
	when(randomizer.getRouletteResult()).thenReturn(randomizerValue);
	Roulette roulette = new Roulette(ball, randomizer);
	
	Roulette.Result actualResult = roulette.playGame();
	
	assertEquals(expectedColor, actualResult.getColor());
	
    }

    private void assertRouletteResult(int randomizerValue, String expectedNumber) {
	Randomizer randomizer = mock(Randomizer.class);
	when(randomizer.getRouletteResult()).thenReturn(randomizerValue);
	Roulette roulette = new Roulette(ball, randomizer);
	
	Roulette.Result actualResult = roulette.playGame();
	
	assertEquals(expectedNumber, actualResult.getNumber());
    }
}
