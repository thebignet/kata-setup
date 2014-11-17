package kata;

public class Lcd {

    public String display(int i) {
	String nl = "\n";
	for (int j = 0; j < 3; j++) {
	    
	}
	String result = "";
	if (i == 7) {
	    result +=" _ " + nl + 
		    "  |" + nl + 
		    "  |" + nl ;
	} else {
	result +="  |" + nl + 
		"  |" + nl + 
		"  |" + nl ;
	}
	return result;
    }

}
