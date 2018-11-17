import org.scalatest._

class ExampleSpec extends FlatSpec with Matchers {

  abstract class Card(val value: Int)
  case class Ace() extends Card(2)
  case class King() extends Card(1)
  case class Queen() extends Card(0)
  def isPair(card1:Card, card2: Card) = card1 == card2

  it should "be a pair when cards have same value" in {
    isPair(Ace(), Ace()) should be(true)
  }

  it should "not be pair when cards have different value" in {
    isPair(Ace(), King()) should be(false)
  }

  def getHighcard(card1: Card, card2: Card) = List(card1, card2).maxBy(_.value).value

  it should "get high card" in {
    getHighcard(King(), Ace()) should be(Ace().value)
    getHighcard(Ace(), King()) should be(Ace().value)
  }

  def getWinner(card1Player1: Card, card2Player1: Card, card1Player2: Card, card2Player2: Card) =
    if(isPair(card1Player1,card2Player1)) Player1
    else if (isPair(card1Player2, card2Player2)) Player2
    else if(getHighcard(card1Player1, card2Player1) > getHighcard(card1Player2, card2Player2)) Player1
    else Player2

  it should "get player when player has pair" in {
    getWinner(King(), King(), King(), Ace()) should be(Player1)
    getWinner(Ace(), King(), King(), King()) should be(Player2)
  }

  it should "get player when player has high card" in {
    getWinner(King(), Ace(), King(), Queen()) should be(Player1)
    getWinner(King(), Queen(), King(), Ace()) should be(Player2)
  }


  object Player1
  object Player2


}