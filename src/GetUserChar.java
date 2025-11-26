import java.util.Scanner;

public interface GetUserChar {
	char getUserChar();
}

public class GetUserRuChar implements GetUserChar{
	private final Scanner sc;

	public GetUserChar(Scanner scanner) {
		this.sc = scanner;
	}

	@Override
	public char getUserChar() {
		Scanner sc = InputProvider.getScanner();

		System.out.println("Введите букву");
		char ch = sc.nextLine().charAt(0);
		ch = Character.toUpperCase(ch);

		while (!Character.isLetter(ch) || !Character.UnicodeBlock.of(ch).equals(Character.UnicodeBlock.CYRILLIC)) {
			System.out.println("Принимаются только русские буквы");

			ch = sc.nextLine().charAt(0);
			ch = Character.toUpperCase(ch);
		}

		return ch;
	}
}
