package primes;

import static org.junit.Assert.*;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class PrimesTest {

    @Test
    public void forNumbersBelow2_noPrimes() {
	Primes primes = new Primes();
	List<Integer> factors = primes.factorsOf(1);
	Assertions.assertThat(factors).isEmpty();
    }

}
