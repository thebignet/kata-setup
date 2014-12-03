package kata;

import java.util.ArrayList;
import java.util.List;

public class PasswordChecker {

    private final class LetterValidator implements Validator {
	@Override
	public void validate(String password, List<String> errors) {
	if (!containsLetter(password))
	    errors.add("Password must contain a letter");
	}
    }

    public class DigitValidator implements Validator {

	@Override
	public void validate(String password, List<String> errors) {
	    if (! password.matches(".*\\d.*"))
		errors.add(ONE_DIGIT);
	}

    }

    static final String MIN_7_CHARS = "Password needs to be 7 chars long";
    static final String ONE_DIGIT = "Password needs to contain atleast one digit";
    private static final String MIN_10_CHARS = null;

    
    private final class LengthValidator implements Validator {
	public void validate(String password, List<String> errors) {
	if (password.length() < 7)
	    errors.add(MIN_7_CHARS);
	
	}
    }

    interface Validator {
	void validate(String password, List<String> errors);
    }
    
    public List<String> check(String password) {
        List<String> errors = emptyList();
        new LengthValidator().validate(password, errors);
        new DigitValidator().validate(password, errors);
        new LetterValidator().validate(password, errors);
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

}
