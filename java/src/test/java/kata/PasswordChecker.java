package kata;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PasswordChecker {

    private List<String> errors = new ArrayList<String>();

    public boolean check(String password) {
        errors.clear();
        boolean result = password.length() >= 7 
                && containsDigit(password)
                && containsLetter(password);
        if (!result) errors.add("oops");
        return result;
    }

    public boolean checkAdmin(String password) {
        errors.clear();
        boolean result = password.length() >= 10
                && check(password)
                && containsSpecialCharacter(password);
        if (!result) errors.add("oops");
        return result;
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

    public List<String> errors() {
        return errors;
    }

}
