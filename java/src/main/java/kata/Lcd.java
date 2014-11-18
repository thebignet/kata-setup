package kata;

import java.util.HashMap;
import java.util.Map;

public class Lcd {

    private Map<Character, String[]> cases = new HashMap<Character, String[]>();

    public Lcd() {
	cases.put('1', new String[] { "   ", "  |", "  |" });
	cases.put('2', new String[] { " _ ", " _|", "|_ " });
	cases.put('7', new String[] { " _ ", "  |", "  |" });
    }

    public String display(int i) {
	String nl = "\n";
	String cumulatitveResult = "";
	for (int line = 0; line < 3; line++) {
	    for (char c : String.valueOf(i).toCharArray()) {
		cumulatitveResult += lcdDigit(c, line);
	    }
	    cumulatitveResult += nl;
	}
	return cumulatitveResult;
    }

    protected String lcdDigit(char digit, int line) {
	return cases.get(digit)[line];
    }

}
