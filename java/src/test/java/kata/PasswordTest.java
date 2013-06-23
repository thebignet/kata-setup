package kata;

import static org.junit.Assert.*;

import org.junit.Test;

public class PasswordTest {
    private PasswordChecker checker = new PasswordChecker();

    @Test public void 
    must_have_7_atleast_chars() {
        assertFalse(check("h"));
        assertFalse(check("helpme"));
        assertTrue(check("helpme7"));
        assertTrue(check("helpme88"));
    }

    @Test public void 
    must_contain_atleast_one_digit() throws Exception {
        assertFalse(check("helpmenow"));
    }
    
    @Test public void 
    must_contain_atleast_one_character() throws Exception {
        assertFalse(check("1234567"));
    }
    
    @Test public void 
    can_contain_capital_letters() throws Exception {
        assertTrue(check("WOW5OCOOL")); 
    }

    private boolean check(String password) {
        return checker.check(password);
    }
    
}
