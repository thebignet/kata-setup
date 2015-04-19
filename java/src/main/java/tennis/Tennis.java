package tennis;

public class Tennis {
    private BeforeTiebreakScore playerAScore = new Love("A");
    private BeforeTiebreakScore playerBScore = new Love("B");

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

    private static class Love extends BeforeTiebreakScore {
        public Love(String name) {
            super(name);
        }

        String format() { return "love"; }
        public BeforeTiebreakScore winsOneBallOver(BeforeTiebreakScore playerAScore) { return new Fifteen(name); }
    }

    private static class Fifteen extends BeforeTiebreakScore {
        public Fifteen(String name) {
            super(name);
        }

        String format() { return "fifteen"; }
        public BeforeTiebreakScore winsOneBallOver(BeforeTiebreakScore playerAScore) { return new Thirty(name); }
    }
    private static class Thirty extends BeforeTiebreakScore {
        public Thirty(String name) {
            super(2, name);
        }

        String format() { return "thirty"; }
        public BeforeTiebreakScore winsOneBallOver(BeforeTiebreakScore otherPlayerScore) {
            wonBalls++;
            if (enteringTieBreak(otherPlayerScore))
                return new Deuce(name);
            return new Forty(name);
        }

    }
    private static class Forty extends BeforeTiebreakScore {
        public Forty(String name) {
            super(3, name);
        }

        String format() { return "forty"; }
        public BeforeTiebreakScore winsOneBallOver(BeforeTiebreakScore otherPlayerScore) {
            wonBalls++;
            return new Game(name);
        }

        @Override
        public BeforeTiebreakScore losesOneBallTo(BeforeTiebreakScore otherPlayerScore) {
            if (enteringTieBreak(otherPlayerScore))
                return new Deuce(name);
            return this;
        }

    }

}