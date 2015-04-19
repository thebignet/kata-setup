package tennis;

public class Tennis {
    private PlayerScore playerAScore = new Love("A");
    private PlayerScore playerBScore = new Love("B");

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

    private static class Love extends PlayerScore {
        public Love(String name) {
            super(name);
        }

        String format() { return "love"; }
        public PlayerScore winsOneBallOver(PlayerScore playerAScore) { return new Fifteen(name); }
    }

    private static class Fifteen extends PlayerScore {
        public Fifteen(String name) {
            super(name);
        }

        String format() { return "fifteen"; }
        public PlayerScore winsOneBallOver(PlayerScore playerAScore) { return new Thirty(name); }
    }
    private static class Thirty extends PlayerScore {
        public Thirty(String name) {
            super(2, name);
        }

        String format() { return "thirty"; }
        public PlayerScore winsOneBallOver(PlayerScore otherPlayerScore) {
            wonBalls++;
            if (enteringTieBreak(otherPlayerScore))
                return new Deuce(name);
            return new Forty(name);
        }

    }
    private static class Forty extends PlayerScore {
        public Forty(String name) {
            super(3, name);
        }

        String format() { return "forty"; }
        public PlayerScore winsOneBallOver(PlayerScore otherPlayerScore) {
            wonBalls++;
            return new Game(name);
        }

        @Override
        public PlayerScore losesOneBallTo(PlayerScore otherPlayerScore) {
            if (enteringTieBreak(otherPlayerScore))
                return new Deuce(name);
            return this;
        }

    }

}