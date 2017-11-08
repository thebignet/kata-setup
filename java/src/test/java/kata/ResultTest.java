package kata;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ResultTest {


    @Test()
    public void theResultIsAlwaysBetween00and36() throws Exception {
        assertNumberResult(0, "0");
        assertNumberResult(12, "12");
        assertNumberResult(36, "36");
        assertNumberResult(37, "00");
    }

    @Test
    public void theColorOf0and00IsGreen() throws Exception {
        assertCorlorResult(0, Result.Color.GREEN);
        assertCorlorResult(37, Result.Color.GREEN);
    }

    @Test
    public void theColorOfEvenNumbersIsBlack() throws Exception {
        assertCorlorResult(2, Result.Color.BLACK);
        assertCorlorResult(14, Result.Color.BLACK);
        assertCorlorResult(36, Result.Color.BLACK);
    }

    @Test
    public void theColorOfOddNumbersIsRed() throws Exception {
        assertCorlorResult(1, Result.Color.RED);
        assertCorlorResult(7, Result.Color.RED);
        assertCorlorResult(35, Result.Color.RED);
    }

    @Test(expected = RouletteException.class)
    public void itThrowsExceptionWhenTheRandomizerIsGreaterThan37()
            throws Exception {

        new Result(38);
        // then exception
    }
    @Test(expected = RouletteException.class)
    public void itThrowsExceptionWhenTheRandomizerIsLesserThan0()
            throws Exception {

        new Result(-1);
        // then exception
    }

    private void assertCorlorResult(int randomizerValue, Result.Color expectedColor) {
        assertEquals(expectedColor, new Result(randomizerValue).getColor());

    }

    private void assertNumberResult(int randomizerValue, String expectedNumber) {
        assertEquals(expectedNumber, new Result(randomizerValue).getNumber());
    }
}