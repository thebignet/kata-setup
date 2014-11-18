package kata;

import java.util.HashMap;
import java.util.Map;

public class Lcd {

    private Map<Integer, String[]> cases = new HashMap<Integer, String[]>();

    public Lcd() {
	cases.put(1, new String[] { "   ", "  |", "  |" });
	cases.put(2, new String[] { " _ ", " _|", "|_ " });
	cases.put(7, new String[] { " _ ", "  |", "  |" });
    }

    public String display(int i) {
	String nl = "\n";
	String result = "";
	for (int line = 0; line < 3; line++) {
	    for (int pos = String.valueOf(i).length(); pos > 0; pos--) {
	        int digit = i % pow(pos) / pow(pos-1);
	        result += appendDigit(digit, result, line);
	        
	    }
	    result += nl;
	}
	return result;
    }

    protected int pow(int pos) {
	return (int)Math.pow(10, pos);
    }

    protected String appendDigit(int digit, String result, int line) {
	return cases.get(digit)[line];
    }

}
