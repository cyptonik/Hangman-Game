public interface IWordMasker {
	String initMask(String randomWord);
	String updateMask(String maskWord, String randomWord, char inputChar);
}
