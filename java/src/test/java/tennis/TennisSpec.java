package tennis;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class TennisSpec {

    private int playerABalls;
    private int playerBBalls;

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
    public void playerBScoresOnce() {
	playerBScores();
	assertThat(score()).isEqualTo("love-fifteen");
    }
    
    @Test
    public void playAScoresTwice() {
	playerAScores();
	playerAScores();
	assertThat(score()).isEqualTo("thirteen-love");
    }

    private String score() {
	if (playerBBalls == 1) return "love-fifteen";
	if (playerABalls == 2) return "thirteen-love";
	if (playerABalls == 1) return "fifteen-love";
	if (playerABalls == 0) return "love-love";
	else throw new RuntimeException("not implemented");
    }
    
    private void playerBScores() {
	playerBBalls++;
    }

    private void playerAScores() {
	playerABalls++;
    }



}
