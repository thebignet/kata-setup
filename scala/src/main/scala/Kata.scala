case class Hand(card1: Card, card2: Card){
  def result: Figure = {
    card1.cardValue.accept(new Visitor[Figure] {
      override def visitCardAce(cardValue: Ace.type): Figure = card2.cardValue.accept(new Visitor[Figure] {
        override def visitCardAce(cardValue: Ace.type): Figure = Pair

        override def visitCardTwo(cardValue: Two.type): Figure = HighCard
      })

      override def visitCardTwo(cardValue: Two.type): Figure = card2.cardValue.accept(new Visitor[Figure] {
        override def visitCardAce(cardValue: Ace.type): Figure = HighCard

        override def visitCardTwo(cardValue: Two.type): Figure = Pair
      })
    })
  }
}

sealed trait Figure
case object Pair extends Figure
case object HighCard extends Figure

case class Card(cardValue: CardValue)

trait Visitor[T] {
  def visitCardAce(cardValue: Ace.type): T
  def visitCardTwo(cardValue: Two.type): T
}

sealed trait CardValue {
  def accept[T](visitor: Visitor[T]): T
}
case object Ace extends CardValue {
  override def accept[T](visitor: Visitor[T]): T = visitor.visitCardAce(this)
}
case object Two extends CardValue {
  override def accept[T](visitor: Visitor[T]): T = visitor.visitCardTwo(this)
}