import org.scalatest._

class ExampleSpec extends FlatSpec with Matchers {

  abstract class Card(val value: Int)
  case class Ace() extends Card(2)
  case class King() extends Card(1)
  def isPair(card1:Card, card2: Card) = card1 == card2

  it should "be a pair when cards have same value" in {
    isPair(Ace(), Ace()) should be(true)
  }

  it should "not be pair when cards have different value" in {
    isPair(Ace(), King()) should be(false)
  }

  def getHighcard(cards: List[Card]) = cards.maxBy(_.value)

  it should "get high card" in {
    getHighcard(List(King(), Ace())) should be(Ace())
    getHighcard(List(Ace(), King())) should be(Ace())
  }

}