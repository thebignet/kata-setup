package kata;


public class Result {
    public enum Color {
      GREEN, RED, BLACK;
    }

    private final String number;
    private final Result.Color color;

    public Result(int intResult) {
		if (intResult < 0 || intResult > 37)
			throw new RouletteException("Result can't be " + intResult);
      this.color = calculateColor(intResult);
      this.number = calculateNumber(intResult);
    }

    private String calculateNumber(int intResult) {
      return intResult == 37 ? "00" : intResult + "";
    }

    private Result.Color calculateColor(int intResult) {
      if (intResult == 0 || intResult == 37)
        return Color.GREEN;
      return intResult % 2 == 0 ? Color.BLACK : Color.RED;
    }

    public String getNumber() {
      return number;
    }

    public Result.Color getColor() {
      return this.color;

    }

  }