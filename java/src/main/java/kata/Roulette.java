package kata;

public class Roulette {

    private Ball ball;
    private Randomizer randomizer;

    public Roulette(Ball ball, Randomizer randomizer) {
	this.ball = ball;
	this.randomizer = randomizer;
    }

    public Result playGame() {
	ball.roll();
	int randomResult = randomizer.getRouletteResult();
	return new Result(randomResult);
    }

    
    public static class Result {
	public enum Color {
	    GREEN, RED, BLACK;
	}

	
	private String result;
	private int intResult;

	public Result(int intResult) {
	    this.intResult = intResult;
	    String numberResult;
	    if (intResult == 37) 
		numberResult = "00";
	    else 
		numberResult = intResult + "";

	    this.result = numberResult;
	}

	public String getNumber() {
	    return result;
	}

	public Color getColor() {
	    if (intResult == 0 || intResult == 37)
		return Color.GREEN;
	    return intResult % 2 == 0 ? Color.BLACK : Color.RED;

	}

    }

}
