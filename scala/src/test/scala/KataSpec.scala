import org.scalatest._

class ExampleSpec extends FlatSpec with Matchers {

  case class Ace()
  def isPair(card1:Ace, card2: Ace) = true

  it should "be a pair when cards have same value" in {
    isPair(Ace(), Ace()) should be(true)
  }

}