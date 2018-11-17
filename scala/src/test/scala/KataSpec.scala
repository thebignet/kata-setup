import org.scalatest._

class ExampleSpec extends FlatSpec with Matchers {

  sealed trait Card
  case class Ace() extends Card
  case class King() extends Card
  def isPair(card1:Card, card2: Card) = card1 == card2

  it should "be a pair when cards have same value" in {
    isPair(Ace(), Ace()) should be(true)
  }

  it should "not be pair when cards have different value" in {
    isPair(Ace(), King()) should be(false)
  }

}