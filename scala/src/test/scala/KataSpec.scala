import org.scalatest._

class ExampleSpec extends FlatSpec with Matchers {

  def isPair = true

  it should "be a pair when cards have same value" in {
    isPair should be(true)
  }

}