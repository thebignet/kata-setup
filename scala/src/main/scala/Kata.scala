

sealed abstract class Card(val value: Int)
case object Ace extends Card(100)
case object Two extends Card(2)
case object Three extends Card(3)
case class Hand(card1: Card, card2: Card) {
  def bestCombination(): Combination = if (card1 == card2) PokerPair(card1)
  else {
    if (card1.value > card2.value) HighCard(card1) else HighCard(card2)
  }
}

sealed trait Combination
case class PokerPair(card: Card) extends Combination
case class HighCard(card: Card) extends Combination

case class Round(hand1: Hand, hand2: Hand) {
  def winner(): Hand = (hand1.bestCombination(), hand2.bestCombination()) match {
    case (PokerPair(card1), PokerPair(card2)) if card1.value > card2.value => hand1
    case (PokerPair(card1), PokerPair(card2)) if card1.value <= card2.value => hand2
    case (PokerPair(_), _) => hand1
    case (_, PokerPair(_)) => hand2
    case (HighCard(card1), HighCard(card2)) if card1.value > card2.value => hand1
    case (HighCard(card1), HighCard(card2)) if card1.value > card2.value => hand2
  }

}