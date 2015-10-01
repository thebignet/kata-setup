package primes;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

public class PrimesTest {

  private Primes primes = new Primes();

  @Test
  public void factors_Of_Primes_Is_Just_The_Prime() {
    assertThat(factorsOf(2)).containsExactly(2);
    assertThat(factorsOf(3)).containsExactly(3);
  }
  
  @Test public void 
  /**
   * numbers Containing Twice One Prime Decompose To Twice The Prime
   * @throws Exception
   */
  numbers_Containing_XTimes_One_Prime_Decompose_To_XTimes_The_Prime() throws Exception {
    assertThat(factorsOf(4)).containsExactly(2, 2);
    assertThat(factorsOf(8)).containsExactly(2, 2, 2);
    assertThat(factorsOf(9)).containsExactly(3, 3);
    assertThat(factorsOf(27)).containsExactly(3, 3, 3);
    assertThat(factorsOf(25)).containsExactly(5, 5);
  }
  
  
  @Test public void 
  acceptanceTest() throws Exception {
    assertThat(factorsOf(2 * 3 * 3 * 29 * 7)).contains(2, 3, 3, 29, 7);
    assertTrue("frreddd".matches("f*r*e*d*"));
  }
  

  private List<Integer> factorsOf(int number) {
    return primes.factorsOf(number);
  }
  
}
