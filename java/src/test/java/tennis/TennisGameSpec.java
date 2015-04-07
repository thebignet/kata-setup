package tennis;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class TennisGameSpec {

    @Test
    public void scoreIsLoveLove_toStartWith() {
	assertThat(score()).isEqualTo("love-love");
    }
    
    

    private String score() {
	return "love-love";
    }

}
