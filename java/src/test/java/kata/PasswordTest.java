package kata;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class PasswordTest {
    private Password checker = new Password();

    @Test public void 
    must_have_7_atleast_chars() {
        assertFalse(check("helpme"));
        assertThat(errorsFor("helpme")).contains("Password needs to be 7 chars long");
    }


    @Test public void 
    must_contain_atleast_one_digit() throws Exception {
        assertFalse(check("helpmenow"));
        assertThat(errorsFor("helpmenow")).contains("Password needs to contain atleast one digit");
    }
    
    @Test public void 
    must_contain_atleast_one_character() throws Exception {
        assertFalse(check("1234567"));
        assertThat(errorsFor("1234567")).contains("Password must contain a letter");
    }
    
    @Test public void 
    passwords_are_valid_when_they_have_letter_number_and_are_atleast_7_chars_long() throws Exception {
    	assertTrue(check("helpme7"));
    }
    
    @Test public void 
    admins_must_have_atleast_10_chars() throws Exception {
        assertFalse(checkAdmin("helpme7"));
        assertThat(errorsForAdmin("1234567")).contains("Password needs to be 10 chars long");
    }
    
    @Test public void 
    admins_must_contain_atleast_one_special_char() throws Exception {
    	assertFalse(checkAdmin("heyYouWom4n"));
    	assertThat(errorsForAdmin("heyYouWom4n")).contains("Password needs to contain atleast one special character");
    }
    
    @Test public void 
    admin_passwords_passes_when_they_have_everything() throws Exception {
    	assertTrue(checkAdmin("10helpme..s"));
    }
    
    
    private boolean checkAdmin(String password) {
        return checker.checkAdmin(password).isEmpty();
    }

    private boolean check(String password) {
        return checker.check(password).isEmpty();
    }
    
    private List<String> errorsFor(String password) {
        return checker.check(password);
    }
    
    private List<String> errorsForAdmin(String password) {
      return checker.checkAdmin(password);
    }

}
