package primes;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class PrimesTest {

    Primes primes = new Primes();
    // 0
    
    @Test
    public void forNumbersBelow2_noPrimes() {
	assertThat(factorsOf(1)).isEmpty();
    }

    @Test public void 
    forPrimes_listOfOnePrime() throws Exception {
	assertThat(factorsOf(2)).contains(2);
	assertThat(factorsOf(3)).contains(3);
	assertThat(factorsOf(5)).contains(5);
    }
    
    @Test public void 
    forMultiplesOfPrimes_thePrimeIsRepeated() throws Exception {
	 assertThat(factorsOf(4)).contains(2, 2);
    }

    private List<Integer> factorsOf(int number) {
	return primes.factorsOf(number);
    }
    
}
