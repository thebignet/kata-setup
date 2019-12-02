import org.scalatest._

class DiamondSpec extends FlatSpec with Matchers {

	"Diamond" should "work for A" in {
		val diamond = new Diamond
		val result = diamond('A')
		result should be(Seq(Seq('A')))
  }

}
