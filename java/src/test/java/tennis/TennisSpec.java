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
	assertThat(tennis.score()).isEqualTo("thirty-love");
    }
    
    @Test
    public void playerBScoresTwice() {
	tennis.playerBScores();
	tennis.playerBScores();
	assertThat(tennis.score()).isEqualTo("love-thirty");
    }
    
    @Test
    public void playerBScoresTrice() {
	tennis.playerBScores();
	tennis.playerBScores();
	tennis.playerBScores();
	assertThat(tennis.score()).isEqualTo("love-forty");
    }
    
    @Test
    public void playerBWinsGame() {
	tennis.playerBScores();
	tennis.playerBScores();
	tennis.playerBScores();
	tennis.playerBScores();
	assertThat(tennis.score()).isEqualTo("game-B");
    }
    @Test
    public void deuce() {
	tennis.playerBScores();
	tennis.playerBScores();
	tennis.playerBScores();
	tennis.playerAScores();
	tennis.playerAScores();
	tennis.playerAScores();
	assertThat(tennis.score()).isEqualTo("deuce");
    }



}
