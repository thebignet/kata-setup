package tennis;

public class Tennis {
    private PlayerScore playerAScore = new Love();
    private PlayerScore playerBScore = new Love();

    public Tennis() {
    }

    void playerBScores() {
        playerBScore = playerBScore.winsOneBallOver(playerAScore);
    }

    void playerAScores() {
        playerAScore = playerAScore.winsOneBallOver(playerBScore);
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
        String format() { return "thirty"; }
        PlayerScore winsOneBallOver(PlayerScore playerAScore) { return new PlayerScore(3); }
    }

}