package tennis;

public class PlayerScore {
    protected int wonBalls;

    public PlayerScore(int wonBalls) {
        this.wonBalls = wonBalls;
    }

    public PlayerScore() {
    }

    PlayerScore winsOneBallOver(PlayerScore otherScore) {
        wonBalls++;
        if (enteringTieBreak(otherScore))
            return new TieBreakScore();
        return this;
    }

    String format() {
        return "forty";
    }

    protected int getWonBalls() {
        return wonBalls;
    }

    boolean enteringTieBreak(PlayerScore otherScore) {
        return getWonBalls() + otherScore.getWonBalls() >= 6;
    }

    String pronounceScore(PlayerScore playerBScore) {
        if (getWonBalls() == 4)
            return "game-A";
        if (playerBScore.getWonBalls() == 4)
            return "game-B";
        return format() + "-" + playerBScore.format();
    }

    public PlayerScore losesOneBallTo(PlayerScore otherPlayerScore) {
        if (otherPlayerScore.enteringTieBreak(this))
            return new TieBreakScore();
        return this;

    }

    public static class TieBreakScore extends PlayerScore {

        public TieBreakScore() {
            super(3);
        }

        @Override
        String format() {
            // should not have this method, missing type in hierarchy
            return super.format();
        }

        @Override
        PlayerScore winsOneBallOver(PlayerScore otherScore) {
            wonBalls++;
            return this;
        }

        @Override
        public PlayerScore losesOneBallTo(PlayerScore otherPlayerScore) {
            return this;
        }

        @Override
        String pronounceScore(PlayerScore playerBScore) {
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
        }
    }
}