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
	String cumulatitveResult = "";
	for (int line = 0; line < 3; line++) {
//	    for (int pos = 0; pos < numberOfDigits(i); pos++) {
//	        int digitAtPos = Integer.valueOf(String.valueOf(i).toCharArray()[pos] + "");
//	        cumulatitveResult += appendDigit(digitAtPos, cumulatitveResult, line);
//	        
//	    }
	    for (char c : String.valueOf(i).toCharArray()) {
		cumulatitveResult += appendDigit(Integer.valueOf(c + ""), cumulatitveResult, line);
		
	    }
	    cumulatitveResult += nl;
	}
	return cumulatitveResult;
    }

    protected int numberOfDigits(int i) {
	return String.valueOf(i).length();
    }

    protected int pow(int pos) {
	return (int)Math.pow(10, pos);
    }

    protected String appendDigit(int digit, String result, int line) {
	return cases.get(digit)[line];
    }

}
