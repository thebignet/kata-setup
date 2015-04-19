package tennis;

/**
* Created by johan on 19/04/15.
*/
public class Game extends BeforeTiebreakScore {

    public Game(String name) {
        super(name);
    }

    @Override
    String format() {
        throw new RuntimeException("must not be called");
    }

    @Override
    public String pronounceScore(BeforeTiebreakScore playerBScore) {
        return "game-" + name;
    }

    @Override
    String pronounceScoreGivenFirstPlayersScoreIs(String format) {
        return "game-" + name;
    }
}
