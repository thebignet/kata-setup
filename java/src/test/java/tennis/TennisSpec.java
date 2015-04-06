package tennis;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class TennisSpec {

    private boolean a;
    private int i;

    @Test
    public void scoreStartsAs_loveLove() {
	assertThat(score()).isEqualTo("love-love");
    }
    
    @Test
    public void playAScoresOnce() {
	playerAScores();
	assertThat(score()).isEqualTo("fifteen-love");
    }
    
    @Test
    public void playAScoresTwice() {
	playerAScores();
	playerAScores();
	assertThat(score()).isEqualTo("thirteen-love");
    }

    private void playerAScores() {
	a = true;
	i++;
    }

    private String score() {
	if (i == 2) return "thirteen-love";
	if (a) return "fifteen-love";
	return "love-love";
    }

}
