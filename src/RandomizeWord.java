import java.util.Random;

public class RandomizeWord implements IChooseRandomWord {
	public String chooseRandomWord(String[] dictionary) {
		Random r = new Random();
		int randomIdx = r.nextInt(dictionary.length);

		return dictionary[randomIdx];
	}
}
