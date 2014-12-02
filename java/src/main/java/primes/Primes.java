package primes;

import static java.util.Arrays.asList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Primes {

    public List<Integer> factorsOf(int i) {
	List<Integer> factors = new ArrayList<Integer>();
	int potentialPrime = 2;
	while (i / potentialPrime >= 1 && i % potentialPrime == 0) {
	    factors.add(potentialPrime);
	    i = i/potentialPrime;
	}
	potentialPrime++;
	while (i / potentialPrime >= 1 && i % potentialPrime == 0) {
	    factors.add(potentialPrime);
	    i = i/potentialPrime;
	}
	potentialPrime++;
	while (i / potentialPrime >= 1 && i % potentialPrime == 0) {
	    factors.add(potentialPrime);
	    i = i/potentialPrime;
	}
	potentialPrime++;
	while (i / potentialPrime >= 1 && i % potentialPrime == 0) {
	    factors.add(potentialPrime);
	    i = i/potentialPrime;
	}
	return factors;
    }

}
