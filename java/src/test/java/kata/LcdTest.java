package kata;

import static org.fest.assertions.api.Assertions.assertThat;

import org.fest.assertions.api.Assertions;
import org.junit.Test;

public class LcdTest {

    @Test
    public void for_one() {
        Lcd lcd = new Lcd();
        String result = lcd.display(1);
        Assertions.assertThat(result).isEqualTo(
        	" | \n" + 
        		" | \n" + 
        		" | \n" );
        	
    }
}
