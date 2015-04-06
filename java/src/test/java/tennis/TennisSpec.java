package tennis;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class TennisSpec {

    private boolean a;

    @Test
    public void scoreStartsAs_loveLove() {
	Assertions.assertThat(score()).isEqualTo("love-love");
    }
    
    @Test
    public void playAScoresOnce() {
	playerAScores();
	Assertions.assertThat(score()).isEqualTo("fifteen-love");
    }

    private void playerAScores() {
	a = true;
	// TODO Auto-generated method stub
	
    }

    private String score() {
	if (a) return "fifteen-love";
	return "love-love";
    }

}
