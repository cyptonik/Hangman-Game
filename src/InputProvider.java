import java.util.Scanner;

final class InputProvider {
	private static final Scanner INSTANCE = new Scanner(System.in);

	private InputProvider() {}

	public static Scanner getScanner() {
		return INSTANCE;
	}
}
