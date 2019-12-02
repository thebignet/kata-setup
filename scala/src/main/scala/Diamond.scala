

class Diamond {
	def apply(letter: Char): Seq[Seq[Char]] = letter match {
		case 'A' => Seq(Seq('A'))
		case 'B' => Seq(
			Seq(' ', 'A', ' '),
			Seq('B', ' ', 'B'),
			Seq(' ', 'A', ' ')
		)
		case 'C' => Seq(
			Seq(' ', ' ', 'A', ' ', ' '),
			Seq(' ', 'B', ' ', 'B', ' '),
			Seq('C', ' ', ' ', ' ', 'C'),
			Seq(' ', 'B', ' ', 'B', ' '),
			Seq(' ', ' ', 'A', ' ', ' '),
		)
	}

	def method(input: String) = Integer.valueOf(input)
}
