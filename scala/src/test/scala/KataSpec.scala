import org.scalatest._

class ExampleSpec extends FlatSpec with Matchers {

  abstract class Card(val valeur: Int) extends Ordered[Card] {
    def compare(that: Card) = this.valeur - that.valeur
  }

  object Ace extends Card(14)
  object King extends Card(13)
  object Queen extends Card(12)

  sealed trait Figure
  case class PokerPair(card: Card) extends Figure
  case class HighCard(card: Card) extends Figure

  case class Hand(card1: Card, card2: Card) {
    def figure: Figure = (card1, card2) match {
      case (first, second) if first == second => PokerPair(first)
      case _ => HighCard(card1)
    }
  }

  case class Round(hand1: Hand, hand2: Hand) {
    def winner = (hand1.figure, hand2.figure) match {
      case (PokerPair(card1), PokerPair(card2)) if card1 > card2 => Some(hand1)
      case (PokerPair(card1), PokerPair(card2)) if card1 == card2 => None
      case (PokerPair(card1), PokerPair(card2)) if card1 < card2 => Some(hand2)
      case (PokerPair(_), _) => Some(hand1)
      case (_, PokerPair(_)) => Some(hand2)
      case (HighCard(card1), HighCard(card2)) if card1 > card2 => Some(hand1)
      case (HighCard(card1), HighCard(card2)) if card1 == card2 => None
      case (HighCard(card1), HighCard(card2)) if card1 < card2 => Some(hand2)
    }
  }

  it should "be a pair when two similar cards" in {
    Hand(Ace, Ace).figure should be(PokerPair(Ace))
  }

  it should "be a high card when two different cards" in {
    Hand(Ace, King).figure should be(HighCard(Ace))
  }

  "better figure" should "win" in {
    Round(Hand(King, King), Hand(Ace, King)).winner should be(Some(Hand(King, King)))
    Round(Hand(Ace, King), Hand(King, King)).winner should be(Some(Hand(King, King)))
  }

  "better pair" should "win" in {
    Round(Hand(King, King), Hand(Ace, Ace)).winner should be(Some(Hand(Ace, Ace)))
    Round(Hand(Ace, Ace), Hand(King, King)).winner should be(Some(Hand(Ace, Ace)))
  }

  "better high card" should "win" in {
    Round(Hand(King, Ace), Hand(Queen, King)).winner should be(Some(Hand(King, Ace)))
    Round(Hand(Queen, King), Hand(King, Ace)).winner should be(Some(Hand(King, Ace)))
  }

  "draws" should "have no winner" in {
    Round(Hand(King, Ace), Hand(King, Ace)).winner should be(None)
    Round(Hand(Queen, Queen), Hand(Queen, Queen)).winner should be(None)
  }

}