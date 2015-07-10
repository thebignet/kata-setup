package kata;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.within;

import org.junit.Test;


public class BallIT {

    
    @Test public void 
    itRollsForAGivenAmountOfTime() throws Exception {
	Ball ball = new Ball();
	
	double before = System.currentTimeMillis();
	ball.roll();
	double after = System.currentTimeMillis();
	
	int twentySeconds = 20000;
	assertThat(after - before).isCloseTo(twentySeconds, within(3d));
	
    }
}
