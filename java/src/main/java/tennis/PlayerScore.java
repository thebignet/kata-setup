package tennis;

public class PlayerScore {
    private int wonBalls;

    public PlayerScore(int wonBalls) {
        this.wonBalls = wonBalls;
    }

    public PlayerScore() {
    }

    PlayerScore winsOneBallOver(PlayerScore otherScore) {
        wonBalls++;
        if (inTieBreak(otherScore))
            ;
        return this;
    }

    String format() {
        return "forty";
    }

    public int getWonBalls() {
        return wonBalls;
    }

    boolean inTieBreak(PlayerScore otherScore) {
        return getWonBalls() + otherScore.getWonBalls() >= 6;
    }

    String pronounceScore(PlayerScore playerBScore) {
        if (inTieBreak(playerBScore)) {
            if (getWonBalls() - playerBScore.getWonBalls() == -2)
                return "game-B";
            if (getWonBalls() - playerBScore.getWonBalls() == -1)
                return "advantage-B";
            if (getWonBalls() - playerBScore.getWonBalls() == 1)
                return "advantage-A";
            if (getWonBalls() - playerBScore.getWonBalls() == 0)
                return "deuce";
            if (getWonBalls() - playerBScore.getWonBalls() == 2)
                return "game-A";
            else
                throw new RuntimeException("cant happen");
        } else {
            if (getWonBalls() == 4)
                return "game-A";
            if (playerBScore.getWonBalls() == 4)
                return "game-B";
            return format() + "-" + playerBScore.format();
        }
    }
}