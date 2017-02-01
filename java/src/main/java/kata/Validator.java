package kata;

import java.util.List;

interface Validator {

    String validate(String password);

    public final class LetterValidator implements Validator {

        @Override
        public String validate(String password) {
            return containsLetter(password) ? "" : "Password must contain a letter";
        }


        private boolean containsLetter(String password) {
            return password.matches(".*[a-zA-Z].*");
        }


    }

    public class DigitValidator implements Validator {

        @Override
        public String validate(String password) {
            return password.matches(".*\\d.*") ? "" : "Password needs to contain atleast one digit";
        }

    }

    public class SpecialCharValidator implements Validator {

        @Override
        public String validate(String password) {
            return containsSpecialCharacter(password) ? "" : "Password needs to contain atleast one special character";
        }

        private boolean containsSpecialCharacter(String password) {
            String nonWordCharacter = "\\W";
            return password.matches(".*" + nonWordCharacter + ".*");
        }


    }

    public final class LengthValidator implements Validator {
        private int length;

        public LengthValidator(int length) {
            this.length = length;
        }

        @Override
        public String validate(String password) {
            return password.length() >= length ? "" : "Password needs to be " + length + " chars long";
        }
    }
}