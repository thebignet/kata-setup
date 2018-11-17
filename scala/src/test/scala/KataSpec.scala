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

  def getWinner(card1Player1: Card, card2Player1: Card, card1Player2: Card, card2Player2: Card) = if(isPair(card1Player1,card2Player1)) "player1" else "player2"

  it should "get player 1 when player 1 has pair" in {
    getWinner(King(), King(), King(), Ace()) should be("player1")
  }



}