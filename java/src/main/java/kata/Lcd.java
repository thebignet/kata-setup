package kata;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lcd {

    private class Digit {
        private List<String> lines;

        public Digit(String...lines) {
            this.lines = Arrays.asList(lines);
        }

        public String forLine(int lineNumber) {
            return lines.get(lineNumber);
        }
    }
    @SuppressWarnings("serial")
    private Map<Character, Digit> cases = new HashMap<Character, Digit>() {{
        put('1', new Digit("   ", "  |", "  |"));
        put('2', new Digit(" _ ", " _|", "|_ "));
        put('7', new Digit(" _ ", "  |", "  |"));
    }};

    private static final Integer[] lineNumbers = {0, 1, 2};
    private static final String NL = "\n";

    public String display(int i) {
        return display(String.valueOf(i));
    }

    protected String display(String number) {
        return display(number.toCharArray());
    }

    protected String display(char[] digits) {
        StringBuilder s = new StringBuilder();
        for (int lineNumber : lineNumbers) {
            for (char digit : digits) {
                s.append(lcdDigit(digit, lineNumber));
            }
            s.append(NL);
        }
        return s.toString();
    }

    protected String lcdDigit(char digit, int line) {
        return cases.get(digit).forLine(line);
    }

}
