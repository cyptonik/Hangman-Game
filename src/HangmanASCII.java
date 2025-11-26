public interface HangmanDisplay {
	void displayHangman(int error);
}

public class HangmanASCII implements HangmanDisplay{
	private static final String[] hangmanPhases = {
		" +---+\n" +
		" |   |\n" +
		"     |\n" +
		"     |\n" +
		"     |\n" +
		"========",

		" +---+\n" +
		" |   |\n" +
		" 0   |\n" +
		"     |\n" +
		"     |\n" +
		"========",

		" +---+\n" +
		" |   |\n" +
		" 0   |\n" +
		" |   |\n" +
		"     |\n" +
		"========",

		" +---+\n" +
		" |   |\n" +
		" 0   |\n" +
		"/|   |\n" +
		"     |\n" +
		"========",

		" +---+\n" +
		" |   |\n" +
		" 0   |\n" +
		"/|\\  |\n" +
		"     |\n" +
		"========",

		" +---+\n" +
		" |   |\n" +
		" 0   |\n" +
		"/|\\  |\n" +
		"/    |\n" +
		"========",

		" +---+\n" +
		" |   |\n" +
		" 0   |\n" +
		"/|\\  |\n" +
		"/ \\  |\n" +
		"========"
	};

	@Override
	public void displayHangman(int error) {
		if (error >= 0 && error < hangmanPhases.length)
			System.out.println(hangmanPhases[error]);
	}
}
