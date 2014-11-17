package kata;

import java.util.HashMap;
import java.util.Map;

public class Lcd {

    private Map<Integer, String> cases = new HashMap<Integer, String>();
    
    public String display(int i) {
	String nl = "\n";
	String result = "";
	if (i == 7) {
	    result +=" _ ";
	} else {
	    result +="  |";
	}
	result +=  nl;
	if (i == 7) {
	    result +="  |";
	} else {
	    result +="  |";
	}
	result +=  nl;
	if (i == 7) {
	    result +="  |";
	} else {
	    result +="  |";
	}
	result +=  nl;
	return result;
    }

}
