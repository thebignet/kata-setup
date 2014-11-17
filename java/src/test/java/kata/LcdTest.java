package kata;

import org.fest.assertions.api.Assertions;
import org.junit.Test;

public class LcdTest {

    @Test
    public void for_one() {
        Lcd lcd = new Lcd();
        String result = lcd.display(1);
        Assertions.assertThat(result).isEqualTo(
        		"  |\n" + 
        		"  |\n" + 
        		"  |\n" );
        	
    }
    @Test
    public void for_7() {
	Lcd lcd = new Lcd();
	String result = lcd.display(7);
	Assertions.assertThat(result).isEqualTo(
		" _ \n" + 
		"  |\n" + 
		"  |\n" );
    }
    
    @Test
    public void for_2() {
	Lcd lcd = new Lcd();
	String result = lcd.display(2);
	Assertions.assertThat(result).isEqualTo(
		" _ \n" + 
		" _|\n" + 
		"|_ \n" );
    }
}
