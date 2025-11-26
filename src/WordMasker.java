
public class WordMasker implements IWordMasker{
	@Override
	public String initMask(String randomWord) {
		return "*".repeat(randomWord.length());
	}

	@Override
	public String updateMask(String maskWord, String randomWord, char inputChar) {
		StringBuilder sb = new StringBuilder(maskWord);
		for (int i = 0; i < randomWord.length(); i++) {
			if (randomWord.charAt(i) == inputChar)
				sb.setCharAt(i, inputChar);
		}
		maskWord = sb.toString();

		return maskWord;
	}
}
