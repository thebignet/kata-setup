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

  public static class RouletteException extends RuntimeException {

    private static final long serialVersionUID = 1L;

	  public RouletteException(String message) {
		  super(message);
	  }
  }

  public static class Result {
    public enum Color {
      GREEN, RED, BLACK;
    }

    private final String number;
    private final Color color;

    public Result(int intResult) {
		if (intResult < 0 || intResult > 37)
			throw new RouletteException("Result can't be " + intResult);
      this.color = calculateColor(intResult);
      this.number = calculateNumber(intResult);
    }

    private String calculateNumber(int intResult) {
      return intResult == 37 ? "00" : intResult + "";
    }

    private Color calculateColor(int intResult) {
      if (intResult == 0 || intResult == 37)
        return Color.GREEN;
      return intResult % 2 == 0 ? Color.BLACK : Color.RED;
    }

    public String getNumber() {
      return number;
    }

    public Color getColor() {
      return this.color;

    }

  }

}
