package kata;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ResultTest {


    @Rule
    public ExpectedException expect = ExpectedException.none();

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

    @Test
    public void itThrowsExceptionWhenTheRandomizerIsGreaterThan37()
            throws Exception {

        expect.expect(RouletteException.class);
        expect.expectMessage("Result can't be 38");

        new Result(38);
    }

    // JUNIT rule
    @Test
    public void itThrowsExceptionWhenTheRandomizerIsLesserThan0()
            throws Exception {

        expect.expect(RouletteException.class);
        expect.expectMessage("Result can't be -1");

        new Result(-1);

    }

    private void assertCorlorResult(int randomizerValue, Result.Color expectedColor) {
        assertEquals(expectedColor, new Result(randomizerValue).getColor());

    }

    private void assertNumberResult(int randomizerValue, String expectedNumber) {
        assertEquals(expectedNumber, new Result(randomizerValue).getNumber());
    }
}