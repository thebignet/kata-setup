package kata;

import java.util.Random;

public final class Between0And37Randomizer implements Randomizer {
	public static final int UPPERLIMIT_FOR_RANDOM_36 = 38;
	private Random random = new Random();
	
	@Override
	public int getRouletteResult() {
		return random.nextInt(UPPERLIMIT_FOR_RANDOM_36);
	}
}