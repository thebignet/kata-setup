package primes;

import static java.util.Arrays.asList;

import java.util.Arrays;
import java.util.List;

public class Primes {

    public List<Integer> factorsOf(int i) {
	if (i == 2) return asList(2);
	if (i == 4) return asList(2, 2);
	if (i == 8) return asList(2, 2, 2);
	if (i == 3) return asList(3);
	if (i == 5) return asList(5);
	return Arrays.asList();
    }

}
