package kata;

import static java.lang.String.valueOf;

import java.util.HashMap;
import java.util.Map;

public class Lcd {

    private static final int LCD_LINES = 3;
    private Map<Character, String[]> cases = new HashMap<>();

    public Lcd() {
	cases.put('1', new String[] { "   ", "  |", "  |" });
	cases.put('2', new String[] { " _ ", " _|", "|_ " });
	cases.put('7', new String[] { " _ ", "  |", "  |" });
    }

    public String display(int i) {
	String nl = "\n";
	StringBuilder r = new StringBuilder();
	for (int line = 0; line < LCD_LINES; line++) {
	    for (char digit : valueOf(i).toCharArray()) {
		r.append(lcdDigit(digit, line));
	    }
	    r.append(nl);
	}
	return r.toString();
    }

    protected String lcdDigit(char digit, int line) {
	return cases.get(digit)[line];
    }

}
