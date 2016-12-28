package kata;

import java.util.*;

public class Lcd {

    private class Digit {
        private List<String> lines;

        public Digit(String line0, String line1, String line2) {
            this.lines = Arrays.asList(line0, line1, line2);
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

    public String display(int number) {
        char[] inputChars = String.valueOf(number).toCharArray();
        List<Digit> digits = getDigitsFormChars(inputChars);
        return display(digits);
    }

    private List<Digit> getDigitsFormChars(char[] inputChars) {
        List<Digit> digits = new ArrayList<>();
        for (char digit : inputChars) {
            digits.add(cases.get(digit));
        }
        return digits;
    }

    private String display(List<Digit> digitDigits) {
        StringBuilder s = new StringBuilder();
        for (int lineNumber : lineNumbers) {
            for (Digit digit : digitDigits) {
                s.append(digit.forLine(lineNumber));
            }
            s.append(NL);
        }
        return s.toString();
    }


}
