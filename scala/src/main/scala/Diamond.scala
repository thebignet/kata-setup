

class Diamond {

	def apply(letter: Char): Seq[Seq[Char]] = diamondLetters(letter).map(diamondLine(letter))

	private def diamondLetters(diamondLetter: Char): Seq[Char] = ('A' until diamondLetter) ++ ('A' to diamondLetter).reverse

	private def diamondLine(diamondLetter: Char)(currentLetter: Char): Seq[Char] = {
		(0 until length(diamondLetter)).map(i =>
			if (i == diamondLetter - currentLetter || i == length(diamondLetter) - (diamondLetter - currentLetter) - 1) currentLetter
			else ' '
		)
	}

	private def length(diamondLetter: Char) = {
		2 * (diamondLetter - 'A') + 1
	}

}
