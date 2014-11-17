package kata;

public class Lcd {

    
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
