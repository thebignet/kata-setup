package kata;

import static java.util.Arrays.asList;

import java.util.ArrayList;
import java.util.List;

import kata.Validator.DigitValidator;
import kata.Validator.LengthValidator;
import kata.Validator.LetterValidator;
import kata.Validator.SpecialCharValidator;

public class Password {
    private List<Validator> userValidators = asList(
            new LengthValidator(7),
            new DigitValidator(),
            new LetterValidator());

    private List<Validator> adminValidators = asList(
            new LengthValidator(10),
            new DigitValidator(),
            new LetterValidator(),
            new SpecialCharValidator());

    public List<String> check(String password) {
        return validate(password, userValidators);
    }

    public List<String> checkAdmin(String password) {
        return validate(password, adminValidators);
    }

    private List<String> validate(String password, List<Validator> validators) {
        List<String> errors = listThatRetainsOnlyActualErrors();
        for (Validator v : validators) {
            errors.add(v.validate(password));
        }
        return errors;
    }


    private ArrayList<String> listThatRetainsOnlyActualErrors() {
        return new ArrayList<String>() {
            @Override
            public boolean add(String s) {
                return s.isEmpty() ? false : super.add(s);
            }
        };
    }

}
