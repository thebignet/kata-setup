package kata;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class Betwen0And37RandomizerIT {

	@Test
	public void randomizerGeneratesRandomNumbersBetween0And37() throws Exception {
		Between0And37Randomizer javaRandomizer = new Between0And37Randomizer();
		
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < 10000; i++) {
			int nextInt = javaRandomizer.getRouletteResult();
			
			list.add(nextInt);
			assertThat(nextInt).isGreaterThanOrEqualTo(0);
			assertThat(nextInt).isLessThanOrEqualTo(37);
		}
		assertThat(list).contains(36);
		assertThat(list).contains(0);
	}
}
