import java.util.*;

public class Game 
{
	private final int numberOfAttempts = 7;

	private final WordsRu source;
    private final IWordMasker masker;
	private final IChooseRandomWord randomizer;
    private final IGetUserChar inputReader;
    private final IHangmanDisplay display;

	private String gameWord;
	private String maskWord;
	private Set<Character> usedChars;

    public Game(WordsRu source, IWordMasker masker, IChooseRandomWord randomizer, 
				IGetUserChar reader, IHangmanDisplay display) {
        this.source = source;
        this.masker = masker;
        this.randomizer = randomizer;
        this.inputReader = reader;
        this.display = display;

		this.gameWord = randomizer.chooseRandomWord(source.dict);
		this.maskWord = masker.initMask(gameWord);
		this.usedChars = new HashSet<>();
    }

	public void runGame() {
		int attemptsLeft = mainGameCycle();

		if (attemptsLeft == 0)
			System.out.println("Вы проиграли - загаданное слово было : " + gameWord);
		else
			System.out.println("Поздравляю, Вы победили!!");
	}

	private int mainGameCycle() {
		int countErrors = 0;
		while (countErrors < numberOfAttempts && maskWord.indexOf('*') != -1) {
			System.out.println(maskWord);
			char inputChar = inputReader.getUserChar();

			if (gameWord.indexOf(inputChar) != -1 && !usedChars.contains(inputChar)) {
				System.out.println("Вы угадали - эта буква есть в слове!");
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

		return numberOfAttempts - countErrors;
	}

}
