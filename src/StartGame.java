public class StartGame {
	public static void main(String[] args) {
		Game game = new Game(new WordsRu(), new WordMasker(), new RandomizeWord(), 
							 new GetUserRuChar(InputProvider.getScanner()), new HangmanASCII());
		game.runGame();
	}
}
