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
	scoreATimes(1);
	assertThat(tennis.score()).isEqualTo("fifteen-love");
    }
    
    @Test
    public void playerBScoresOnce() {
	scoreBTimes(1);
	assertThat(tennis.score()).isEqualTo("love-fifteen");
    }
    
    @Test
    public void playAScoresTwice() {
	scoreATimes(2);
	assertThat(tennis.score()).isEqualTo("thirty-love");
    }
    
    @Test
    public void playerBScoresTwice() {
	scoreBTimes(2);
	assertThat(tennis.score()).isEqualTo("love-thirty");
    }
    
    @Test
    public void playerBScoresTrice() {
	scoreBTimes(3);
	assertThat(tennis.score()).isEqualTo("love-forty");
    }
    
    @Test
    public void playerBWinsGame() {
	scoreBTimes(4);
	assertThat(tennis.score()).isEqualTo("game-B");
    }
    @Test
    public void playerAWinsGame() {
	scoreATimes(4);
	assertThat(tennis.score()).isEqualTo("game-A");
    }
    
    @Test
    public void deuce() {
	scoreBTimes(3);
	scoreATimes(3);
	assertThat(tennis.score()).isEqualTo("deuce");
    }
    
    @Test
    public void advantageA() {
	scoreBTimes(3);
	scoreATimes(4);
	assertThat(tennis.score()).isEqualTo("advantage-A");
    }

    private void scoreBTimes(int times) {
	for (int i = 0; i < times; i++) {
	    tennis.playerBScores();
	}
    }
    private void scoreATimes(int times) {
	for (int i = 0; i < times; i++) {
	    tennis.playerAScores();
	}
    }



}
