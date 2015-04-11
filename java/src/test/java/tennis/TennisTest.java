package tennis;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class TennisTest {

    private Tennis tennis = new Tennis();

    @Test
    public void scoreStartsAs_loveLove() {
        assertScoreIs("love-love");
    }

    @Test
    public void playAScoresOnce() {
        playerAScoresTimes(1);
        assertScoreIs("fifteen-love");
    }

    @Test
    public void playerBScoresOnce() {
        playerBScoresTimes(1);
        assertScoreIs("love-fifteen");
    }

    @Test
    public void playAScoresTwice() {
        playerAScoresTimes(2);
        assertScoreIs("thirty-love");
    }

    @Test
    public void playerBScoresTwice() {
        playerBScoresTimes(2);
        assertScoreIs("love-thirty");
    }

    @Test
    public void playerBScoresTrice() {
        playerBScoresTimes(3);
        assertScoreIs("love-forty");
    }

    @Test
    public void playerBWinsGame() {
        playerBScoresTimes(3);
        playerBScores();
        assertScoreIs("game-B");
    }

    @Test
    public void playerAWinsGame() {
        playerAScoresTimes(4);
        assertScoreIs("game-A");
    }

    @Test
    public void tieBreak_deuce() {
        playerBScoresTimes(3);
        playerAScoresTimes(3);
        assertScoreIs("deuce");
    }

    @Test
    public void tieBreak_advantageA() {
        playerBScoresTimes(3);
        playerAScoresTimes(2);
        playerAScores();
        playerAScores();
        assertScoreIs("advantage-A");
    }

    @Test
    public void tieBreak_advantageB() {
        playerAScoresTimes(3);
        playerBScoresTimes(4);
        assertScoreIs("advantage-B");
    }

    @Test
    public void tieBreak_advantageBAfterMorePlay() {
        playerAScoresTimes(3);
        playerBScoresTimes(4);
        assertScoreIs("advantage-B");

        playerAScores();
        playerBScores();
        assertScoreIs("advantage-B");

        playerAScores();
        playerBScores();
        assertScoreIs("advantage-B");
    }

    @Test
    public void tieBreak_deuceAfterMorePlay() {
        playerAScoresTimes(3);
        playerBScoresTimes(3);
        assertScoreIs("deuce");

        playerAScores();
        playerBScores();
        assertScoreIs("deuce");

        playerAScores();
        playerBScores();
        assertScoreIs("deuce");

        playerAScores();
        playerBScores();
        assertScoreIs("deuce");
    }

    @Test
    public void tieBreak_advantageAAfterMorePlay() throws Exception {
        playerBScoresTimes(3);
        playerAScoresTimes(4);

        playerBScores();
        playerAScores();
        assertScoreIs("advantage-A");

        playerBScores();
        playerAScores();
        assertScoreIs("advantage-A");
    }

    @Test
    public void tieBreak_playerWins() throws Exception {
        playerBScoresTimes(3);
        playerAScoresTimes(4);

        playerBScores();
        playerAScores();
        assertScoreIs("advantage-A");

        playerAScores();
        assertScoreIs("game-A");
    }

    private void playerBScoresTimes(int times) {
        for (int i = 0; i < times; i++) {
            playerBScores();
        }
    }

    private void playerAScoresTimes(int times) {
        for (int i = 0; i < times; i++) {
            playerAScores();
        }
    }


    private void playerAScores() {
        tennis.playerAScores();
    }

    private void playerBScores() {
        tennis.playerBScores();
    }

    private void assertScoreIs(String expectedScore) {
        assertThat(tennis.score()).isEqualTo(expectedScore);
    }


}
