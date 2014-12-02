package primes;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class PrimesTest {

    // 0
    
    @Test
    public void forNumbersBelow2_noPrimes() {
	Primes primes = new Primes();
	Assertions.assertThat(primes.factorsOf(1)).isEmpty();
    }
    
    @Test public void 
    testname() throws Exception {
	Primes primes = new Primes();
	Assertions.assertThat(primes.factorsOf(2)).contains(2);
    }

}
