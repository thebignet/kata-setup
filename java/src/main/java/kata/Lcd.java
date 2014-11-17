package kata;

public class Lcd {

    public String display(int i) {
	String nl = "\n";
	if (i == 7) {
	    return  " _ " + nl + 
		    "  |" + nl + 
		    "  |" + nl ;
	}
	return  "  |" + nl + 
		"  |" + nl + 
		"  |" + nl ;
    }

}
