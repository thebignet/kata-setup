import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class HelloWorldTest {

    @Test
    void shouldSayHelloWorld(){
        //Given
        HelloWorld helloWorld = new HelloWorld();
        //When
        String hello = helloWorld.sayHello();
        //Then
        assertThat(hello).isEqualTo("Hello World !");
    }
}