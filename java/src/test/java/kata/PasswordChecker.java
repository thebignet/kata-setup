package kata;

public class PasswordChecker {

    public boolean check(String password) {
        return password.length() >= 7 
                && password.matches(".*\\d.*")
                && password.matches(".*[a-zA-Z].*");
    }

}
