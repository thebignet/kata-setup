import org.scalatest._

class ExampleSpec extends FlatSpec with Matchers {

  /*"Kata" should "convert string of 1 to number 1" in {
    val kata = new Kata
    val result = kata.method("1")
    result should be(1)
  }

  it should "throw NumberFormatException if input is not a number" in {
    val kata = new Kata
    a[NumberFormatException] should be thrownBy {
      kata.method("a")
    }
  }*/

  it should "start with a failing test" in {
    succeed
  }

}