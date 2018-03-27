import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class HelloWorldTest {

    @Test
    void shouldSayHelloWorld(){
        HelloWorld helloWorld = new HelloWorld();
        String hello = helloWorld.sayHello();
        assertThat(hello).isEqualTo("Hello World !");
    }
}