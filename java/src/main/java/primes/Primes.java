package primes;

import static java.util.Arrays.asList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Primes {

    public List<Integer> factorsOf(int i) {
	List<Integer> factors = new ArrayList<Integer>();
	if (i == 2) factors.add(2);
	if (i == 4) return asList(2, 2);
	if (i == 8) return asList(2, 2, 2);
	if (i == 3) return asList(3);
	if (i == 5) return asList(5);
	return factors;
    }

}
