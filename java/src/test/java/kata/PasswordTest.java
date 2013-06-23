package kata;

import static kata.PasswordChecker.MIN_7_CHARS;
import static org.fest.assertions.api.Assertions.assertThat;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class PasswordTest {
    private PasswordChecker checker = new PasswordChecker();

    @Test public void 
    must_have_7_atleast_chars() {
        assertFalse(check("h"));
        assertFalse(check("helpme"));
        assertThat(errorsFor("helpme")).contains(MIN_7_CHARS);
        assertTrue(check("helpme7"));
        assertTrue(check("helpme88"));
    }


    @Test public void 
    must_contain_atleast_one_digit() throws Exception {
        assertFalse(check("helpmenow"));
        assertThat(errorsFor("helpmenow")).contains(PasswordChecker.ONE_DIGIT);
    }
    
    @Test public void 
    must_contain_atleast_one_character() throws Exception {
        assertFalse(check("1234567"));
    }
    
    @Test public void 
    can_contain_capital_letters() throws Exception {
        assertTrue(check("WOW5OCOOL")); 
    }

    
    @Test public void 
    admins_must_have_atleast_10_chars() throws Exception {
        assertFalse(checkAdmin("helpme7"));
        assertTrue(checkAdmin("10helpme.."));
    }
    
    @Test public void 
    admins_must_contain_atleast_one_digit() throws Exception {
        assertFalse(checkAdmin("helpmenowpleas"));
    }
    
    @Test public void 
    admins_must_contain_atleast_one_letter() throws Exception {
        assertFalse(checkAdmin("1234567890"));
    }
    
    @Test public void 
    admins_must_contain_atleast_one_special_char() throws Exception {
        assertFalse(checkAdmin("heyYouWom4n"));
        assertTrue(checkAdmin(".heyYouWom4n"));
        assertTrue(checkAdmin("hey!YouWom4n"));
        assertTrue(checkAdmin("hey?YouWom4n"));
    }
    
    private boolean checkAdmin(String password) {
        return checker.checkAdmin(password).hasErrors();
    }

    private boolean check(String password) {
        return checker.check(password).hasErrors();
    }
    
    private List<String> errorsFor(String password) {
        return checker.check(password).errors();
    }

}
