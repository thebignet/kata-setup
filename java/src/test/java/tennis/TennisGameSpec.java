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
	String love = "love";
	if (aBalls == 3) return format(3) + "-" + format(0) ;
	if (aBalls == 2) return format(2) + "-" + format(0);
	if (aBalls == 1) return format(1) + "-" + format(0);
	if (aBalls == 0) return format(0) + "-" + format(0);
	return love + "-" + love;
    }

    private String format(int score) {
	if (score == 3) return "forty";
	if (score == 2) return "thirty";
	if (score == 1) return "fifteen";
	return "love";
    }

}
