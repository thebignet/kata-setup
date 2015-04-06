package tennis;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class TennisSpec {

    private Tennis tennis = new Tennis();

    @Test
    public void scoreStartsAs_loveLove() {
	assertScoreIs("love-love");
    }
    
    @Test
    public void playAScoresOnce() {
	scoreATimes(1);
	assertScoreIs("fifteen-love");
    }
    
    @Test
    public void playerBScoresOnce() {
	scoreBTimes(1);
	assertScoreIs("love-fifteen");
    }
    
    @Test
    public void playAScoresTwice() {
	scoreATimes(2);
	assertScoreIs("thirty-love");
    }
    
    @Test
    public void playerBScoresTwice() {
	scoreBTimes(2);
	assertScoreIs("love-thirty");
    }
    
    @Test
    public void playerBScoresTrice() {
	scoreBTimes(3);
	assertScoreIs("love-forty");
    }
    
    @Test
    public void playerBWinsGame() {
	scoreBTimes(4);
	assertScoreIs("game-B");
    }
    @Test
    public void playerAWinsGame() {
	scoreATimes(4);
	assertScoreIs("game-A");
    }
    
    @Test
    public void deuce() {
	scoreBTimes(3);
	scoreATimes(3);
	assertScoreIs("deuce");
    }
    
    @Test
    public void advantageA() {
	scoreBTimes(3);
	scoreATimes(4);
	assertScoreIs("advantage-A");
    }
    
    @Test
    public void advantageB() {
	scoreATimes(3);
	scoreBTimes(4);
	assertScoreIs("advantage-B");
    }
    
    @Test
    public void advantageBAfterMorePlay() {
	scoreATimes(3);
	scoreBTimes(4);
	assertScoreIs("advantage-B");
	tennis.playerAScores();
	assertScoreIs("deuce");
	tennis.playerBScores();
	assertScoreIs("advantage-B");
	tennis.playerAScores();
	tennis.playerBScores();
	assertScoreIs("advantage-B");
    }
    
    @Test public void 
    advantageAAfterMorePlay() throws Exception {
	 scoreBTimes(3);
	 scoreATimes(4);
	 
	 tennis.playerBScores();
	 tennis.playerAScores();
	 assertScoreIs("advantage-A");
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


    private void assertScoreIs(String expectedScore) {
	assertThat(tennis.score()).isEqualTo(expectedScore);
    }


}
