import java.util.Scanner;

public class GetUserRuChar implements IGetUserChar{
	private final Scanner sc;

	public GetUserRuChar(Scanner scanner) {
		this.sc = scanner;
	}

	@Override
	public char getUserChar() {
		System.out.println("Введите букву");
		String input = sc.nextLine();
		while (input.length() == 0) 
			input = sc.nextLine();

		char ch = input.charAt(0);
		ch = Character.toUpperCase(ch);

		while (!Character.isLetter(ch) || !Character.UnicodeBlock.of(ch).equals(Character.UnicodeBlock.CYRILLIC)) {
			System.out.println("Принимаются только русские буквы");

			ch = sc.nextLine().charAt(0);
			ch = Character.toUpperCase(ch);
		}

		return ch;
	}
}
