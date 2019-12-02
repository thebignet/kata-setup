import org.scalatest._

class DiamondSpec extends FlatSpec with Matchers {

	"Diamond" should "work for A" in {
		val diamond = new Diamond
		val result = diamond('A')
		result should be(Seq(Seq('A')))
  }

	it should "work for B" in {
		val diamond = new Diamond
		val result = diamond('B')
		result should be(Seq(
			Seq(' ', 'A', ' '),
			Seq('B', ' ', 'B'),
			Seq(' ', 'A', ' ')
		))
	}

	it should "work for C" in {
		val diamond = new Diamond
		val result = diamond('C')
		result should be(Seq(
			Seq(' ', ' ', 'A', ' ', ' '),
			Seq(' ', 'B', ' ', 'B', ' '),
			Seq('C', ' ', ' ', ' ', 'C'),
			Seq(' ', 'B', ' ', 'B', ' '),
			Seq(' ', ' ', 'A', ' ', ' '),
		))
	}

}
