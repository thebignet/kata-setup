package primes;

import static java.util.Arrays.asList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Primes {

  public List<Integer> factorsOf(int number) {
    ArrayList<Integer> factors = new ArrayList<>();
    
    
    int potentialPrime = 2;
    
    for (int i = 0; i < number; i++) {
      while(number % potentialPrime == 0) {
        factors.add(potentialPrime);
        number = number / potentialPrime;
      }
      potentialPrime++;
      
    }
    
    return factors;
  }

}
