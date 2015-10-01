package primes;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

public class PrimesTest {

  private Primes primes = new Primes();

  @Test
  public void factorsOfPrimesIsJustThePrime() {
    assertThat(factorsOf(2)).containsExactly(2);
    assertThat(factorsOf(3)).containsExactly(3);
  }
  
  @Ignore @Test public void 
  acceptanceTest() throws Exception {
    assertThat(factorsOf(2 * 3 * 3 * 29 * 7)).containsExactly(2, 3, 3, 29, 7);
     
  }

  private List<Integer> factorsOf(int number) {
    return primes.factorsOf(number);
  }
  
}
