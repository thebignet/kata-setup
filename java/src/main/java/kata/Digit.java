package kata;

import java.util.Arrays;
import java.util.List;

class Digit {
    private List<String> lines;

    /**
     * Enumerating line0, 1 and 2 instead of accepting an array/list
     * ensures we have three and only three lines
     */
    public Digit(String line0, String line1, String line2) {
        this.lines = Arrays.asList(line0, line1, line2);
    }

    public String forLine(int lineNumber) {
        return lines.get(lineNumber);
    }
}
