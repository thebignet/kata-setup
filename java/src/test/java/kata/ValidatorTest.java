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
  
  Validator letterValidator = new Validator.LetterValidator();
  ArrayList<String> errorList = new ArrayList<>();
   
  @Test public void 
  letterValidatorPassesWhenThereIsALetter() throws Exception {
    letterValidator.validate("q", errorList);
    assertThat(errorList).isEmpty();
  }
  
  @Test public void 
  letterValidatorAddsErrorWhenThereIsNoletter() throws Exception {    
    letterValidator.validate("6", errorList);
    assertThat(errorList).contains("Password must contain a letter");
  }
  
  @Test public void 
  lenghtValidatorPassesWhenStringIsEqualOrLongerThanLength() throws Exception {
    Validator lengthValidator = new Validator.LengthValidator(3);
    lengthValidator.validate("123", errorList);
    assertThat(errorList).isEmpty();
  }
  
  @Test public void 
  lenghtValidatorAddsErrorWhenTheStringIsShorterThanLength() throws Exception {
    Validator lengthValidator = new Validator.LengthValidator(3);
    lengthValidator.validate("12", errorList);
    assertThat(errorList).contains("Password needs to be 3 chars long");
  }
  

  @Test public void 
  specialCharacterValidatorAddsErrorWhenThereIsNoSpecialCharacter() throws Exception {  
    Validator validator = new Validator.SpecialCharValidator();
    validator.validate("a", errorList);
    assertThat(errorList).contains("Password needs to contain atleast one special character");
  }
  

  @Test public void 
  specialCharacterValidatorPassesWhenThereIsAtleastOneSpecialCharacter() throws Exception {  
    Validator validator = new Validator.SpecialCharValidator();
    validator.validate("a!", errorList);
    assertThat(errorList).isEmpty();;
  }

}
