package tennis;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class TennisSpec {

    private Tennis tennis = new Tennis();


    @Test
    public void scoreStartsAs_loveLove() {
	assertThat(tennis.score()).isEqualTo("love-love");
    }
    
    @Test
    public void playAScoresOnce() {
	tennis.playerAScores();
	assertThat(tennis.score()).isEqualTo("fifteen-love");
    }
    
    @Test
    public void playerBScoresOnce() {
	tennis.playerBScores();
	assertThat(tennis.score()).isEqualTo("love-fifteen");
    }
    
    @Test
    public void playAScoresTwice() {
	tennis.playerAScores();
	tennis.playerAScores();
	assertThat(tennis.score()).isEqualTo("thirteen-love");
    }



}
