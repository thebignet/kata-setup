package kata;

import static org.junit.Assert.*;

import java.util.ArrayList;

import kata.Validator.LetterValidator;

import org.fest.assertions.api.Assertions;
import org.junit.Test;

public class ValidatorTest  {
  
  LetterValidator letterValidator = new Validator.LetterValidator();
  ArrayList<String> errorList = new ArrayList<>();
  
  @Test public void 
  letterValidatorPassesWhenThereIsALetter() throws Exception {
    
    letterValidator.validate("q", errorList);
    
    Assertions.assertThat(errorList).isEmpty();
  }
  
  @Test public void 
  letterValidatorAddsError_When_there_Is_No_letter() throws Exception {
    
    
    letterValidator.validate("6", errorList);
    
    Assertions.assertThat(errorList).contains("Password must contain a letter");
  }

}
