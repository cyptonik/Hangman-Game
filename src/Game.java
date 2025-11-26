import java.util.*;

public class Game 
{
	private final int numberOfAttempts = 7;

	private final WordsRu source;
    private final IWordMasker masker;
	private final IChooseRandomWord randomizer;
    private final GetUserChar inputReader;
    private final HangmanDisplay display;

	private String gameWord;
	private String maskWord;

    public Game(WordsRu source, IWordMasker masker, ChooseRandomWord randomizer, GetUserChar reader, HangmanDisplay display) {
        this.wordSource = source;
        this.masker = masker;
        this.randomizer = randomizer;
        this.inputReader = reader;
        this.display = display;
		this.gameWord = randomizer.chooseRandomWord(source.ruDict);
		this.maskWord = masker.initMask(gameWord);
    }

	public void runGame() {
		int countErrors = 0;
		Set<Character> usedChars = new HashSet<>();

		mainGameCycle(countErrors);

		if ((numberOfAttempts - countErrors) == 0)
			System.out.println("Вы проиграли - загаданное слово было : " + gameWord);
		else
			System.out.println("Поздравляю, Вы победили!!");
	}

	private void mainGameCycle(int countErrors) {
		while (countErrors < numberOfAttempts && maskWord.indexOf('*') != -1) {
			System.out.println(maskWord);
			char inputChar = inputReader.getUserChar();

			if (gameWord.indexOf(inputChar) != -1 && !usedChars.contains(inputChar)) {
				//System.out.println("Вы угадали - эта буква есть в слове!");
				usedChars.add(inputChar);
				maskWord = masker.updateMask(maskWord, gameWord, inputChar);
			}
			else if (usedChars.contains(inputChar)) {
				System.out.println("Символ уже был использован");
				System.out.println("Использованные символы : " + usedChars);
				continue;
			}
			else {
				System.out.println("Вы ошиблись =(");
				usedChars.add(inputChar);
				display.displayHangman(countErrors);
				countErrors++;
			}

			if (usedChars.size() > 0)
				System.out.println("Использованные символы : " + usedChars);

			System.out.println("Осталось попыток : " + (numberOfAttempts - countErrors) + '\n');
		}
	}

}
