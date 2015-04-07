package tennis;

import java.util.Map;

import com.google.common.collect.ImmutableMap;

public class TieBreak extends Tennis {

    public TieBreak(Tennis tennis) {
	this.playerABalls = tennis.playerABalls;
	this.playerBBalls = tennis.playerBBalls;
    }

    @Override
    public String score() {
	Map<Integer, String> relativeScore = ImmutableMap.of(
		-2, "game-B",
		-1, "advantage-B",
		 0, "deuce",
		 1, "advantage-A",
		 2, "game-A"
		);
	    int scoreDifference = playerABalls - playerBBalls;
	    return relativeScore.get(scoreDifference);
    }

}
