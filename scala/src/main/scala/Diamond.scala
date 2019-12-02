

class Diamond {

	def apply(letter: Char): Seq[Seq[Char]] = letter match {
		// nombre de lignes : 2 n - 1
		// nombres de colonnes : 2 n - 1
		case 'A' => Seq(Seq('A'))
		case 'B' => Seq(
			diamondLine('B')('A'),
			diamondLine('B')('B'),
			diamondLine('B')('A')
		)
		case _ => Seq(
			diamondLine('C')('A'),
			diamondLine('C')('B'),
			diamondLine('C')('C'),
			diamondLine('C')('B'),
			diamondLine('C')('A')
		)
	}

	private def diamondLine(diamondLetter: Char)(currentLetter: Char): Seq[Char] = {
		line(2 * (diamondLetter - 'A') + 1, currentLetter, diamondLetter - currentLetter)
	}

	private def line(length: Int, letter: Char, position: Int) = {
		Range(0, length).map(i => if (i == position || i == length - position - 1) letter else ' ')
	}

	def method(input: String) = Integer.valueOf(input)
}
