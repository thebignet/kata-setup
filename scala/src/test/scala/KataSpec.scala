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
  }

  it should "start with a failing test" in {
    fail
  }

  ignore should "show how to ignore a test" in {
    succeed
  }*/

  it should "be a pair when two card with same value" in {
    val hand = Hand(Ace, Ace)
    hand.bestCombination() match {
      case PokerPair(Ace) => succeed
      case _ => fail
    }
  }

  it should "be a high card when two card have different values" in {
    val hand = Hand(Ace, Two)
    hand.bestCombination() match {
      case HighCard(Ace) => succeed
      case _ => fail
    }
  }

  "the winner hand between a pair and a high card" should "be a pair" in {
    val handWithPair = Hand(Ace, Ace)
    val handWithHighCard = Hand(Ace, Two)

    val winner = Round(handWithHighCard, handWithPair).winner()

    winner should be(handWithPair)
  }

  "the winner between two high cards" should "be the one with the highest" in {
    val handWithHighest = Hand(Ace, Two)
    val handWithLowest = Hand(Two, Three)

    val winner = Round(handWithHighest, handWithLowest).winner()

    winner should be(handWithHighest)
  }

  "the winner between two pairs" should "be the one with the highest" in {
    val handWithHighest = Hand(Ace, Ace)
    val handWithLowest = Hand(Two, Two)

    val winner = Round(handWithLowest, handWithHighest).winner()

    winner should be(handWithHighest)
  }
}