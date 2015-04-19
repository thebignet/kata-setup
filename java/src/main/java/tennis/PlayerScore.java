package tennis;

public abstract class PlayerScore {
    protected int wonBalls;
    protected String name;

    public PlayerScore() {
    }

    public PlayerScore(int wonBalls) {
        this.wonBalls = wonBalls;
    }

    public PlayerScore(String name) {
        this.name = name;
    }

    public PlayerScore(int wonBalls, String name) {
        this.wonBalls = wonBalls;
        this.name = name;
    }

    PlayerScore winsOneBallOver(PlayerScore otherScore) {
        wonBalls++;
        if (enteringTieBreak(otherScore))
            return new TieBreakScore(name);
        return this;
    }

    // needed only for the beginning
    abstract String format();

    protected int getWonBalls() {
        return wonBalls;
    }

    boolean enteringTieBreak(PlayerScore otherScore) {
        return getWonBalls() + otherScore.getWonBalls() >= 6;
    }

    String pronounceScore(PlayerScore playerBScore) {
        return playerBScore.pronounceScoreGivenFirstPlayersScoreIs(format());
    }

    String pronounceScoreGivenFirstPlayersScoreIs(String format) {
        return format + "-" + format();
    }

    public PlayerScore losesOneBallTo(PlayerScore otherPlayerScore) {
        if (otherPlayerScore.enteringTieBreak(this))
            return new TieBreakScore(name);
        return this;

    }

    public static class TieBreakScore extends PlayerScore {

        public TieBreakScore(String name) {
            super(3, name);
        }

        protected TieBreakScore() {

        }

        @Override
        String format() {
            // should not have this method, missing type in hierarchy
            throw new RuntimeException("todo make this impossible");
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
    public static class Advantage extends TieBreakScore {

        public Advantage(String name) {
            super();
            this.name = name;
        }

        @Override
        PlayerScore winsOneBallOver(PlayerScore otherScore) {
            return new Game(name);
        }

        @Override
        public PlayerScore losesOneBallTo(PlayerScore otherPlayerScore) {
            return super.losesOneBallTo(otherPlayerScore);
        }

        @Override
        String format() {
            return "advantage-" + name;
        }
    }
}