package kata;

import static java.util.Arrays.asList;

import java.util.Collections;
import java.util.List;

public class PasswordChecker {

    public class Validation {

        private boolean result;

        public Validation(boolean result) {
            this.result = result;
        }

        public boolean hasErrors() {
            return result;
        }

        public List<String> errors() {
            if (result == false) return asList(MIN_7_CHARS);
            return Collections.emptyList();
        }

    }

    static final String MIN_7_CHARS = "Password needs to be 7 chars long";
    static final String ONE_DIGIT = "Password needs to contain atleast one digit";

    public Validation check(String password) {
        boolean result = password.length() >= 7 
                && containsDigit(password)
                && containsLetter(password);
        
        return new Validation(result);
    }

    public Validation checkAdmin(String password) {
        boolean result = password.length() >= 10 
                && check(password).hasErrors()
                && containsSpecialCharacter(password);
        
        return new Validation(result);
    }

    private boolean containsSpecialCharacter(String password) {
        return password.matches(".*[\\.!?].*");
    }

    private boolean containsLetter(String password) {
        return password.matches(".*[a-zA-Z].*");
    }

    private boolean containsDigit(String password) {
        return password.matches(".*\\d.*");
    }

}
