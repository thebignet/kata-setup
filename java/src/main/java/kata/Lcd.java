package kata;

import java.util.HashMap;
import java.util.Map;

public class Lcd {

    private static final int LCD_LINES = 3;
    private Map<Character, String[]> cases = new HashMap<>();
    private static final Integer[] lines = {0, 1, 2};		
    private static final String NL = "\n";

    public Lcd() {
	cases.put('1', new String[] { "   ", "  |", "  |" });
	cases.put('2', new String[] { " _ ", " _|", "|_ " });
	cases.put('7', new String[] { " _ ", "  |", "  |" });
    }

    public String display(int i) {
	return display(String.valueOf(i));
    }

    protected String display(String number) {
	return display(number.toCharArray());
    }

    protected String display(char[] digits) {
	StringBuilder r = new StringBuilder();
	for (int line : lines) {
	    for (char digit : digits) {
		r.append(lcdDigit(digit, line));
	    }
	    r.append(NL);
	}
	return r.toString();
    }

    protected String lcdDigit(char digit, int line) {
	return cases.get(digit)[line];
    }

}
