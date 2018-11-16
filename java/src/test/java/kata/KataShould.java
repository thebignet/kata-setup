package kata;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class KataShould {

    @Test
    public void startWithAFailingTest() {
        Assertions.fail("start by implementing a test");
    }

    @ParameterizedTest
    @ValueSource(strings = { "Hello", "JUnit" })
    void withValueSource(String word) {
        assertNotNull(word);
    }
}
