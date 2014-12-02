package primes;

import static java.util.Arrays.asList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Primes {

    public List<Integer> factorsOf(int number) {
	List<Integer> factors = new ArrayList<Integer>();
	for (int potentialPrime = 2; potentialPrime <= number; potentialPrime++) {
	    for (; stillOneFactorToGo(number, potentialPrime); number = number/potentialPrime) {
		factors.add(potentialPrime);
		
	    }
	}
	return factors;
    }

    private boolean stillOneFactorToGo(int number, int potentialPrime) {
	return number > 1 && isDividableBy(number, potentialPrime);
    }

    private boolean isDividableBy(int number, int potentialPrime) {
	return number % potentialPrime == 0;
    }

}
