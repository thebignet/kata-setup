package tennis;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class TennisGameSpec {

    private int aBalls;

    @Test
    public void scoreIsLoveLove_toStartWith() {
	assertThat(score()).isEqualTo("love-love");
    }
    
    @Test
    public void scoreIsFifteenLove_whenPlayerAScoresOnce() {
	playerAScores();
	assertThat(score()).isEqualTo("fifteen-love");
    }
    
    @Test
    public void scoreIsThirtyLove_whenPlayerAScoresTwice() {
	playerAScores();
	playerAScores();
	assertThat(score()).isEqualTo("thirty-love");
    }
    
    @Test
    public void scoreIsFortyLove_whenPlayerAScoresTrice() {
	playerAScores();
	playerAScores();
	playerAScores();
	assertThat(score()).isEqualTo("forty-love");
    }
    
    

    private void playerAScores() {
	aBalls++;
    }

    private String score() {
	return format(aBalls) + "-" + format(0) ;
    }

    private String format(int score) {
	if (score == 3) return "forty";
	if (score == 2) return "thirty";
	if (score == 1) return "fifteen";
	return "love";
    }

}
