package kata;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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
    
    @Test public void 
    theResultIsAlwaysBetween0and36() throws Exception {
	assertRouletteResult(0, 0);
	assertRouletteResult(12, 12);
	assertRouletteResult(36, 36);
	 
    }

    private void assertRouletteResult(int randomizerResult, int rouletteResult) {
	when(randomizer.getRouletteResult()).thenReturn(randomizerResult);
	Roulette roulette = new Roulette(ball, randomizer);
	
	int result = roulette.playGame();
	
	assertEquals(rouletteResult, result);
    }
}
