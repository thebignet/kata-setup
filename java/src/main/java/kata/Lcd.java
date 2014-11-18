package kata;

import java.util.HashMap;
import java.util.Map;

public class Lcd {

    private Map<Integer, String[]> cases = new HashMap<Integer, String[]>();
    public Lcd() {
	cases.put(7, new String[]{" _ ", "  |", "  |"});
	cases.put(1, new String[]{"  |", "  |", "  |"});
	cases.put(2, new String[]{" _ ", " _|", "|_ "});
    }
    public String display(int i) {
	String nl = "\n";
	String result = "";
	for (int line = 0; line < 3; line++) {
	    if (i > 100) {
		result += appendDigit(i%1000 / 100, result, line);
		result += appendDigit(i%100 / 10, result, line);
		result += appendDigit(i%10 / 1, result, line);
	    }
	    else if (i > 10) {
		    result += appendDigit(i / 10, result, line);
		    result += appendDigit(i/10 / 1, result, line);
		    
	    } else {
		result += appendDigit(i, result, line);
		
	    }
	    result +=  nl;
	}
	return result;
    }
    protected String appendDigit(int digit, String result, int line) {
	return cases.get(digit)[line];
    }

}
