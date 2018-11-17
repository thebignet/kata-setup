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

  "two card with same value" should "be a pair" in {
    val hand = Hand(Card(Ace),Card(Ace))
    hand.result match {
      case Pair => succeed
      case _ => fail
    }
  }

  "two card with different value" should "be a high card" in {
    val hand = Hand(Card(Ace),Card(Two))
    hand.result match {
      case HighCard => succeed
      case _ => fail
    }
  }

}