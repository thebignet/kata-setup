package tennis;

public class Tennis {
    private PlayerScore playerAScore = new PlayerScore.Love("A");
    private PlayerScore playerBScore = new PlayerScore.Love("B");

    public Tennis() {
    }

    public void playerBScores() {
        playerBScore = playerBScore.winsOneBallOver(playerAScore);
        playerAScore = playerAScore.losesOneBallTo(playerBScore);
    }

    public void playerAScores() {
        playerAScore = playerAScore.winsOneBallOver(playerBScore);
        playerBScore = playerBScore.losesOneBallTo(playerAScore);
    }

    public String score() {
        return playerAScore.pronounceScore(playerBScore);

    }

}