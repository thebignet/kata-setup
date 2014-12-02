package primes;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class PrimesTest {

    Primes primes = new Primes();
    // 0
    
    @Test
    public void forNumbersBelow2_noPrimes() {
	Assertions.assertThat(factorsOf(1)).isEmpty();
    }

    @Test public void 
    for2_listOf2s() throws Exception {
	Assertions.assertThat(factorsOf(2)).contains(2);
    }

    private List<Integer> factorsOf(int number) {
	return primes.factorsOf(number);
    }
    
}
