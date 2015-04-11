package tennis;

public class Tennis {
    private PlayerScore playerAScore = new PlayerScore();
    private PlayerScore playerBBalls = new PlayerScore();

    public Tennis() {
    }

    Tennis playerBScores() {
        playerBBalls.playerScores();
        return this;
    }

    Tennis playerAScores() {
        playerAScore.playerScores();
        return this;
    }

    String score() {
        return format(playerAScore.playerABalls, playerBBalls.playerABalls);
    }

    private String format(int unused, int unused2) {
        if (inBeginningOfGame()) {
            if (playerAScore.playerABalls == 4)
                return "game-A";
            if (playerBBalls.playerABalls == 4)
                return "game-B";
            return playerAScore.format(playerAScore.playerABalls) + "-" + playerAScore.format(playerBBalls.playerABalls);
        } else {
            if (playerAScore.playerABalls - playerBBalls.playerABalls == -2)
                return "game-B";
            if (playerAScore.playerABalls - playerBBalls.playerABalls == -1)
                return "advantage-B";
            if (playerAScore.playerABalls - playerBBalls.playerABalls == 1)
                return "advantage-A";
            if (playerAScore.playerABalls - playerBBalls.playerABalls == 0)
                return "deuce";
            if (playerAScore.playerABalls - playerBBalls.playerABalls == 2)
                return "game-A";
            else
                throw new RuntimeException("cant happen");
        }

    }

    private boolean inBeginningOfGame() {
        return playerAScore.playerABalls + playerBBalls.playerABalls < 6;
    }

}