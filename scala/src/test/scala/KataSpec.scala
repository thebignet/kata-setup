import org.scalatest._

class ExampleSpec extends FlatSpec with Matchers {

  abstract class Card(val valeur: Int) extends Ordered[Card] {
    def compare(that: Card) = this.valeur - that.valeur
  }
  case object Ace extends Card(14)
  case object King extends Card(13)
  case object Queen extends Card(12)
  case class StartWith(card: Card){
    def andAdd(nextCard: Card): Score = if(card == nextCard) PokerPair(card) else{
      if(card > nextCard) HighCard(card) else HighCard(nextCard)
    }
  }

  sealed trait Score {
    def withOtherScore(score: Score) = (this,score) match {
      case (PokerPair(_), HighCard(_)) => Player1Wins
      case (HighCard(_), PokerPair(_)) => Player2Wins
      case (PokerPair(a), PokerPair(b)) if b > a => Player2Wins
      case (PokerPair(a), PokerPair(b)) if b < a => Player1Wins
      case (HighCard(a), HighCard(b)) if b > a => Player2Wins
      case (HighCard(a), HighCard(b)) if b < a => Player1Wins
    }

  }

  sealed trait WinningPlayer
  object Player1Wins extends WinningPlayer
  object Player2Wins extends WinningPlayer

  case class PokerPair(card: Card) extends Score
  case class HighCard(card: Card) extends Score


  "same cards" should "be a pair" in {
    StartWith(Ace).andAdd(Ace) should be(PokerPair(Ace))
  }

  "different cards" should "be a high card" in {
    StartWith(Ace).andAdd(King) should be(HighCard(Ace))
    StartWith(King).andAdd(Ace) should be(HighCard(Ace))
  }
  "highest score" should "be on type of score" in {
    StartWith(King).andAdd(Ace).withOtherScore(StartWith(Ace).andAdd(Ace)) should be(Player2Wins)
  }
  it should "be on value for pairs" in {
    StartWith(King).andAdd(King).withOtherScore(StartWith(Ace).andAdd(Ace)) should be(Player2Wins)
    StartWith(Ace).andAdd(Ace).withOtherScore(StartWith(King).andAdd(King)) should be(Player1Wins)
  }
  it should "be on value for high cards" in {
    StartWith(King).andAdd(Ace).withOtherScore(StartWith(King).andAdd(Queen)) should be(Player1Wins)
    StartWith(King).andAdd(Queen).withOtherScore(StartWith(King).andAdd(Ace)) should be(Player2Wins)
  }
}