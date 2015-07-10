package kata;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;

public class RouletteTest {

    @Test
    public void itWaitsForTheBallToStop() {
	Ball ball = mock(Ball.class);
        Roulette roulette = new Roulette(ball);
        
        roulette.playGame();
        
        verify(ball).roll();
       
    }
}
