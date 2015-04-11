package tennis;

public class Tennis {
    private PlayerScore playerAScore = new Love();
    private PlayerScore playerBScore = new Love();

    public Tennis() {
    }

    void playerBScores() {
        playerBScore = playerBScore.winsOneBallOver(playerAScore);
        playerAScore = playerAScore.losesOneBallTo(playerBScore);
    }

    void playerAScores() {
        playerAScore = playerAScore.winsOneBallOver(playerBScore);
        playerBScore = playerBScore.losesOneBallTo(playerAScore);
    }

    String score() {
        return playerAScore.pronounceScore(playerBScore);

    }

    private static class Love extends PlayerScore {
        String format() { return "love"; }
        PlayerScore winsOneBallOver(PlayerScore playerAScore) { return new Fifteen(); }
    }

    private static class Fifteen extends PlayerScore {
        String format() { return "fifteen"; }
        PlayerScore winsOneBallOver(PlayerScore playerAScore) { return new Thirty(); }
    }
    private static class Thirty extends PlayerScore {
        public Thirty() {
            super(2);
        }

        String format() { return "thirty"; }
        PlayerScore winsOneBallOver(PlayerScore otherPlayerScore) {
            wonBalls++;
            if (enteringTieBreak(otherPlayerScore))
                return new TieBreakScore();
            return new PlayerScore(3); }

    }

}