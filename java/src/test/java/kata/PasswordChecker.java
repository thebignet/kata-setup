package kata;

import java.util.ArrayList;
import java.util.List;

public class PasswordChecker {

    static final String MIN_7_CHARS = "Password needs to be 7 chars long";
    static final String ONE_DIGIT = "Password needs to contain atleast one digit";
    private static final String MIN_10_CHARS = null;

    public List<String> check(String password) {
        List<String> errors = emptyList();
        addUnless(password.length() >= 7, MIN_7_CHARS, errors);
        addUnless(containsDigit(password), ONE_DIGIT, errors);
        addUnless(containsLetter(password), ONE_DIGIT, errors);
        return errors;
    }

    public List<String> checkAdmin(String password) {
        List<String> errors = emptyList();
        errors.addAll(check(password));
        addUnless(password.length() >= 10, MIN_10_CHARS, errors);
        addUnless(containsSpecialCharacter(password), ONE_DIGIT, errors);
        return errors;
    }
    
    private void addUnless(boolean condition, String error, List<String> errors) {
        if (! condition) 
            errors.add(error);
    }

    private ArrayList<String> emptyList() {
        return new ArrayList<String>();
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
