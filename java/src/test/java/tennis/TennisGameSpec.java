package tennis;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class TennisGameSpec {

    private boolean aScored;

    @Test
    public void scoreIsLoveLove_toStartWith() {
	assertThat(score()).isEqualTo("love-love");
    }
    
    @Test
    public void scoreIsFifteenLove_whenPlayerAScoresOnce() {
	playerAScores();
	assertThat(score()).isEqualTo("fifteen-love");
    }
    
    

    private void playerAScores() {
	aScored = true;
	
    }

    private String score() {
	if (aScored) return "fifteen-love";
	return "love-love";
    }

}
