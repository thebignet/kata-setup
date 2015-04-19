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

    public PlayerScore winsOneBallOver(PlayerScore opponentScore) {
        wonBalls++;
        if (enteringTieBreak(opponentScore))
            return new Deuce(name);
        return this;
    }

    public PlayerScore losesOneBallTo(PlayerScore opponentScore) {
        if (opponentScore.enteringTieBreak(this))
            return new Deuce(name);
        return this;

    }

    public String pronounceScore(PlayerScore playerBScore) {
        return playerBScore.pronounceScoreGivenFirstPlayersScoreIs(format());
    }

    // needed only for the beginning
    abstract String format();

    protected int getWonBalls() {
        return wonBalls;
    }

    boolean enteringTieBreak(PlayerScore opponentScore) {
        return getWonBalls() + opponentScore.getWonBalls() >= 6;
    }

    String pronounceScoreGivenFirstPlayersScoreIs(String format) {
        return format + "-" + format();
    }

    public abstract PlayerScore otherPlayerShouldEnterFortyOrDeuce(Tennis.Thirty thirty);

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
        public PlayerScore otherPlayerShouldEnterFortyOrDeuce(Tennis.Thirty thirty) {
            throw new RuntimeException("can't happen");
        }

        @Override
        public PlayerScore winsOneBallOver(PlayerScore opponentScore) {
            return new Advantage(name);
        }

        @Override
        public PlayerScore losesOneBallTo(PlayerScore opponentScore) {
            return new NonAdvantage(name);
        }

        @Override
        public String pronounceScore(PlayerScore playerBScore) {
            return "deuce";
        }
    }
    public static class Advantage extends Deuce {

        public Advantage(String name) {
            super(name);
        }

        @Override
        public PlayerScore winsOneBallOver(PlayerScore opponentScore) {
            return new Game(name);
        }

        @Override
        public PlayerScore losesOneBallTo(PlayerScore opponentScore) {
            return new Deuce(name);
        }

        @Override
        public String pronounceScore(PlayerScore playerBScore) {
            return "advantage-" + name;
        }
    }
    public static class NonAdvantage extends Deuce {

        public NonAdvantage(String name) {
            super(name);
        }

        @Override
        public PlayerScore winsOneBallOver(PlayerScore opponentScore) {
            return new Deuce(name);
        }

        @Override
        public PlayerScore losesOneBallTo(PlayerScore opponentScore) {
            return new Game(opponentScore.name);
        }

        @Override
        public String pronounceScore(PlayerScore playerBScore) {
            return "advantage-" + playerBScore.name;
        }
    }
}