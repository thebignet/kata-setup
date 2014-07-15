package kata;

import static org.fest.assertions.api.Assertions.assertThat;

import org.junit.Test;

public class BowlingTest {
    Bowling bowling = new Bowling();

    @Test
    public void score() {
        assertThat(bowling.score(0, 0, 0)).isEqualTo(0);
        assertThat(bowling.score(1, 1, 1)).isEqualTo(3);
        
        assertThat(bowling.score(1, 9, 5, 1)).isEqualTo(21);
        assertThat(bowling.score(5, 0, 1, 9)).isEqualTo(15); // spare but no more throws
        assertThat(bowling.score(5, 0, 1, 9, 9, 1)).isEqualTo(34);
        
//        assertThat(bowling.score(10, 1, 5, 0)).isEqualTo(20); illegal
        assertThat(bowling.score(10, 0, 5, 1)).isEqualTo(22);
        
//        assertThat(bowling.score(8, 1, 9)).isEqualTo(18);
    }
}
