package kata;

public class Lcd {

    public String display(int i) {
	String nl = "\n";
	String result = "";
	if (i == 7) {
	    result +=" _ " + nl;
	} else {
	    result +="  |" + nl;
	}
	for (int j = 1; j < 3; j++) {
	    if (i == 7) {
		result +="  |" + nl ;
	    } else {
		result +="  |" + nl ;
	    }
	    
	}
	return result;
    }

}
