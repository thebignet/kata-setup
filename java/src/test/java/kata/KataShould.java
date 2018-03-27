package kata;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class KataShould {

    @Test
    void startWithAFailingTest() {
        var message = "start by implementing a test";
        assertThat(message).isBlank();
    }
}
