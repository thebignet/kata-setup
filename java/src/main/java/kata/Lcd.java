package kata;

import java.util.HashMap;
import java.util.Map;

public class Lcd {

    @SuppressWarnings("serial")
    private Map<Character, String[]> cases = new HashMap<Character, String[]>() {{
        put('1', new String[]{"   ", "  |", "  |"});
        put('2', new String[]{" _ ", " _|", "|_ "});
        put('7', new String[]{" _ ", "  |", "  |"});
    }};

    private static final Integer[] lines = {0, 1, 2};
    private static final String NL = "\n";

    public String display(int i) {
        return display(String.valueOf(i));
    }

    protected String display(String number) {
        return display(number.toCharArray());
    }

    protected String display(char[] digits) {
        StringBuilder s = new StringBuilder();
        for (int line : lines) {
            for (char digit : digits) {
                s.append(lcdDigit(digit, line));
            }
            s.append(NL);
        }
        return s.toString();
    }

    protected String lcdDigit(char digit, int line) {
        return cases.get(digit)[line];
    }

}
