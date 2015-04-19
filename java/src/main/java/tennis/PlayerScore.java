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
            return new Deuce(name);
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
            return new Deuce(name);
        return this;

    }

    public static class Deuce extends PlayerScore {

        public Deuce(String name) {
            super(3, name); // the 3 is needed because one player goes in to deuce before the other so
            // the enteringTieBreak function wont work
        }

        @Override
        String format() {
            // should not have this method, missing type in hierarchy
            throw new RuntimeException("todo make this impossible");
        }

        @Override
        PlayerScore winsOneBallOver(PlayerScore otherScore) {
            return new Advantage(name);
        }

        @Override
        public PlayerScore losesOneBallTo(PlayerScore otherPlayerScore) {
            return new NonAdvantage(name);
        }

        @Override
        String pronounceScore(PlayerScore playerBScore) {
            return "deuce";
        }
    }
    public static class Advantage extends Deuce {

        public Advantage(String name) {
            super(name);
        }

        @Override
        PlayerScore winsOneBallOver(PlayerScore otherScore) {
            return new Game(name);
        }

        @Override
        public PlayerScore losesOneBallTo(PlayerScore otherPlayerScore) {
            return new Deuce(name);
        }

        @Override
        String pronounceScore(PlayerScore playerBScore) {
            return "advantage-" + name;
        }
    }
    public static class NonAdvantage extends Deuce {

        public NonAdvantage(String name) {
            super(name);
        }

        @Override
        PlayerScore winsOneBallOver(PlayerScore otherScore) {
            return new Deuce(name);
        }

        @Override
        public PlayerScore losesOneBallTo(PlayerScore otherPlayerScore) {
            return new Game(otherPlayerScore.name);
        }

        @Override
        String pronounceScore(PlayerScore playerBScore) {
            return "advantage-" + playerBScore.name;
        }
    }
}