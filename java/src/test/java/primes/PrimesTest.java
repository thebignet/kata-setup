package primes;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class PrimesTest {
    Primes primes = new Primes();

    @Test
    public void any_number_below_2_has_no_factors() {
        assertThat(factorsOf(1)).isEmpty();
        assertThat(factorsOf(0)).isEmpty();
        assertThat(factorsOf(-3)).isEmpty();
    }

    @Test public void 
    primes_are_just_returned_wrapped_in_a_list() throws Exception {
        assertThat(factorsOf(2)).containsExactly(2);
        assertThat(factorsOf(3)).containsExactly(3);
        assertThat(factorsOf(5)).containsExactly(5);
    }

    @Test public void 
    the_list_contains_the_same_prime_as_many_times_as_the_number_can_be_divided_by_it() throws Exception {
        assertThat(factorsOf(8)).containsExactly(2, 2, 2);
        assertThat(factorsOf(27)).containsExactly(3, 3, 3);
        assertThat(factorsOf(125)).containsExactly(5, 5, 5);
    }
    
    @Test public void 
    it_handles_any_prime() throws Exception {
         assertThat(factorsOf(41 * 37 * 19 *2 * 3 )).containsExactly(2, 3, 19,  37, 41);
    }
    
    
    
    private List<Integer> factorsOf(int number) {
        return primes.factorsOf(number);
    }
    
}
