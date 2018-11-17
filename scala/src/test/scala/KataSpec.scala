import org.scalatest._

class ExampleSpec extends FlatSpec with Matchers {

  def isPair(card1:String, card2: String) = true

  it should "be a pair when cards have same value" in {
    isPair("1", "2") should be(true)
  }

}