package primes;

import static java.util.Arrays.asList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Primes {

    public List<Integer> factorsOf(int i) {
	List<Integer> factors = new ArrayList<Integer>();
	while (i / 2 >= 1 && i % 2 == 0) {
	    factors.add(2);
	    i = i/2;
	}
	while (i / 3 >= 1 && i % 3 == 0) {
	    factors.add(3);
	    i = i/3;
	}
	if (i == 5) factors.add(5);
	return factors;
    }

}
