package kata;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.junit.Assert.*;

import java.util.ArrayList;

import kata.Validator.LengthValidator;
import kata.Validator.LetterValidator;
import kata.Validator.SpecialCharValidator;

import org.fest.assertions.api.Assertions;
import org.junit.Test;

public class ValidatorTest  {
  

  @Test public void
  letterValidatorPassesWhenThereIsALetter() throws Exception {
    Validator letterValidator = new Validator.LetterValidator();
    assertThat(letterValidator.validate("q")).isEmpty();
  }

  @Test public void
  letterValidatorAddsErrorWhenThereIsNoletter() throws Exception {
    Validator letterValidator = new Validator.LetterValidator();
    assertThat(letterValidator.validate("6")).contains("Password must contain a letter");
  }
  
  @Test public void 
  lenghtValidatorPassesWhenStringIsEqualOrLongerThanLength() throws Exception {
    Validator lengthValidator = new Validator.LengthValidator(3);
    assertThat(lengthValidator.validate("123")).isEmpty();
  }
  
  @Test public void 
  lenghtValidatorAddsErrorWhenTheStringIsShorterThanLength() throws Exception {
    Validator lengthValidator = new Validator.LengthValidator(3);
    assertThat(lengthValidator.validate("12")).contains("Password needs to be 3 chars long");
  }
  

  @Test public void 
  specialCharacterValidatorAddsErrorWhenThereIsNoSpecialCharacter() throws Exception {  
    Validator validator = new Validator.SpecialCharValidator();
    assertThat(validator.validate("a")).contains("Password needs to contain atleast one special character");
  }
  

  @Test public void 
  specialCharacterValidatorPassesWhenThereIsAtleastOneSpecialCharacter() throws Exception {  
    Validator validator = new Validator.SpecialCharValidator();
    assertThat(validator.validate("a!")).isEmpty();
  }

}
