package tennis;

public class Tennis {
    private PlayerScore playerAScore = new Love("A");
    private PlayerScore playerBScore = new Love("B");

    public Tennis() {
    }

    void playerBScores() {
        playerBScore = playerBScore.winsOneBallOver(playerAScore);
        playerAScore = playerAScore.losesOneBallTo(playerBScore);
    }

    void playerAScores() {
        playerAScore = playerAScore.winsOneBallOver(playerBScore);
        playerBScore = playerBScore.losesOneBallTo(playerAScore);
    }

    String score() {
        return playerAScore.pronounceScore(playerBScore);

    }

    private static class Love extends PlayerScore {
        public Love(String name) {
            super(name);
        }

        String format() { return "love"; }
        PlayerScore winsOneBallOver(PlayerScore playerAScore) { return new Fifteen(name); }
    }

    private static class Fifteen extends PlayerScore {
        public Fifteen(String name) {
            super(name);
        }

        String format() { return "fifteen"; }
        PlayerScore winsOneBallOver(PlayerScore playerAScore) { return new Thirty(name); }
    }
    private static class Thirty extends PlayerScore {
        public Thirty(String name) {
            super(2, name);
        }

        String format() { return "thirty"; }
        PlayerScore winsOneBallOver(PlayerScore otherPlayerScore) {
            wonBalls++;
            if (enteringTieBreak(otherPlayerScore))
                return new TieBreakScore(name);
            return new Forty(name);
        }

    }
    private static class Forty extends PlayerScore {
        public Forty(String name) {
            super(3, name);
        }

        String format() { return "forty"; }
        PlayerScore winsOneBallOver(PlayerScore otherPlayerScore) {
            wonBalls++;
            return new Game(name);
        }

        @Override
        public PlayerScore losesOneBallTo(PlayerScore otherPlayerScore) {
            if (enteringTieBreak(otherPlayerScore))
                return new TieBreakScore(name);
            return this;
        }

    }
    private static class Game extends PlayerScore {

        public Game(String name) {
            super(name);
        }

        @Override
        String pronounceScore(PlayerScore playerBScore) {
            return "game-" + name;
        }

        @Override
        String pronounceScoreGivenFirstPlayersScoreIs(String format) {
            return "game-" + name;
        }
    }

}