package kata;

import java.util.*;

public class Lcd {

    @SuppressWarnings("serial")
    private Map<Character, Digit> possibleDigits = new HashMap<Character, Digit>() {{
        put('1', new Digit("   ", "  |", "  |"));
        put('2', new Digit(" _ ", " _|", "|_ "));
        put('7', new Digit(" _ ", "  |", "  |"));
    }};

    private static final Integer[] lineNumbers = {0, 1, 2};
    private static final String NL = "\n";

    /**
     * Accept only and integer, so we're sure that from here we have only valid input
     */
    public String displayDigitList(int number) {
        char[] inputChars = String.valueOf(number).toCharArray();
        List<Digit> digits = getDigitsFormChars(inputChars);
        return displayDigitList(digits);
    }

    /**
     * switch to domain objects (instead of primitives ASAP
     */
    private List<Digit> getDigitsFormChars(char[] inputChars) {
        List<Digit> digits = new ArrayList<>();
        for (char charDigit : inputChars) {
            digits.add(possibleDigits.get(charDigit));
        }
        return digits;
    }

    private String displayDigitList(List<Digit> digitDigits) {
        StringBuilder s = new StringBuilder();

        s.append(getLine(digitDigits, 0));
        s.append(getLine(digitDigits, 1));
        s.append(getLine(digitDigits, 2));
        
        return s.toString();
    }

    private String getLine(List<Digit> digitDigits, int lineNumber) {
        StringBuilder lineSb = new StringBuilder();
        for (Digit digit : digitDigits) {
            lineSb.append(digit.forLine(lineNumber));
        }
        lineSb.append(NL);
        return lineSb.toString();
    }


}
