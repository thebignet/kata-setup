package tennis;

public abstract class BeforeTiebreakScore {
    protected int wonBalls;
    protected String name;

    public BeforeTiebreakScore() {
    }

    public BeforeTiebreakScore(int wonBalls) {
        this.wonBalls = wonBalls;
    }

    public BeforeTiebreakScore(String name) {
        this.name = name;
    }

    public BeforeTiebreakScore(int wonBalls, String name) {
        this.wonBalls = wonBalls;
        this.name = name;
    }

    public BeforeTiebreakScore winsOneBallOver(BeforeTiebreakScore otherScore) {
        wonBalls++;
        if (enteringTieBreak(otherScore))
            return new Deuce(name);
        return this;
    }

    public BeforeTiebreakScore losesOneBallTo(BeforeTiebreakScore otherPlayerScore) {
        if (otherPlayerScore.enteringTieBreak(this))
            return new Deuce(name);
        return this;

    }

    public String pronounceScore(BeforeTiebreakScore playerBScore) {
        return playerBScore.pronounceScoreGivenFirstPlayersScoreIs(format());
    }

    // needed only for the beginning
    abstract String format();

    protected int getWonBalls() {
        return wonBalls;
    }

    boolean enteringTieBreak(BeforeTiebreakScore otherScore) {
        return getWonBalls() + otherScore.getWonBalls() >= 6;
    }

    String pronounceScoreGivenFirstPlayersScoreIs(String format) {
        return format + "-" + format();
    }

    public static class Deuce extends BeforeTiebreakScore {

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
        public BeforeTiebreakScore winsOneBallOver(BeforeTiebreakScore otherScore) {
            return new Advantage(name);
        }

        @Override
        public BeforeTiebreakScore losesOneBallTo(BeforeTiebreakScore otherPlayerScore) {
            return new NonAdvantage(name);
        }

        @Override
        public String pronounceScore(BeforeTiebreakScore playerBScore) {
            return "deuce";
        }
    }
    public static class Advantage extends Deuce {

        public Advantage(String name) {
            super(name);
        }

        @Override
        public BeforeTiebreakScore winsOneBallOver(BeforeTiebreakScore otherScore) {
            return new Game(name);
        }

        @Override
        public BeforeTiebreakScore losesOneBallTo(BeforeTiebreakScore otherPlayerScore) {
            return new Deuce(name);
        }

        @Override
        public String pronounceScore(BeforeTiebreakScore playerBScore) {
            return "advantage-" + name;
        }
    }
    public static class NonAdvantage extends Deuce {

        public NonAdvantage(String name) {
            super(name);
        }

        @Override
        public BeforeTiebreakScore winsOneBallOver(BeforeTiebreakScore otherScore) {
            return new Deuce(name);
        }

        @Override
        public BeforeTiebreakScore losesOneBallTo(BeforeTiebreakScore otherPlayerScore) {
            return new Game(otherPlayerScore.name);
        }

        @Override
        public String pronounceScore(BeforeTiebreakScore playerBScore) {
            return "advantage-" + playerBScore.name;
        }
    }
}