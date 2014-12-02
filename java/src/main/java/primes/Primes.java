package primes;

import static java.util.Arrays.asList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Primes {

    public List<Integer> factorsOf(int number) {
	List<Integer> factors = new ArrayList<Integer>();
	for (int potentialPrime = 2; potentialPrime <=number; potentialPrime++) {
	    while (number >= potentialPrime && isDividableBy(number, potentialPrime)) {
		factors.add(potentialPrime);
		number = number/potentialPrime;
	    }
	}
	return factors;
    }

    protected boolean isDividableBy(int number, int potentialPrime) {
	return number % potentialPrime == 0;
    }

}
