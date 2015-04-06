package tennis;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class TennisSpec {

    @Test
    public void scoreStartsAs_loveLove() {
	Assertions.assertThat(score()).isEqualTo("love-love");
    }

    private String score() {
	return "love-love";
    }

}
