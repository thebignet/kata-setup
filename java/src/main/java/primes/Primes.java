package primes;

import java.util.ArrayList;
import java.util.List;

public class Primes {
    
    public List<Integer> factorsOf(int number) {
        List<Integer> factors = emptyList();
        int potentialPrime = 2;
        while (potentialPrime <= number) {
            while (isFactorOf(potentialPrime, number)) {
                factors.add(potentialPrime);
                number = number / potentialPrime;
            }
            potentialPrime++;
        }
        return factors;
    }

    private boolean isFactorOf(int potentialPrime, int number) {
        return number % potentialPrime == 0;
    }

    private ArrayList<Integer> emptyList() {
        return new ArrayList<Integer>();
    }

}
