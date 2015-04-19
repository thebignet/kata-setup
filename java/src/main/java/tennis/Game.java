package tennis;

/**
* Created by johan on 19/04/15.
*/
public class Game extends PlayerScore {

    public Game(String name) {
        super(name);
    }

    @Override
    String format() {
        throw new RuntimeException("must not be called");
    }

    @Override
    public String pronounceScore(PlayerScore playerBScore) {
        return "game-" + name;
    }

    @Override
    String pronounceScoreGivenFirstPlayersScoreIs(String format) {
        return "game-" + name;
    }

    @Override
    public PlayerScore otherPlayerShouldEnterFortyOrDeuce(Tennis.Thirty thirty) {
        throw new RuntimeException("can't happen");
    }


}
