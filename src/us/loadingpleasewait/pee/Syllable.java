package us.loadingpleasewait.pee;

public class Syllable extends PinyinString {
	
	private static final long serialVersionUID = 7226678250347009023L;

	public Syllable() {
		super("");
	}
	
	public Syllable(String input) {
		super(input);
	}

	/* (non-Javadoc)
	 * @see us.loadingpleasewait.pee.PinyinString#getPinyin()
	 */
	@Override
	public String getPinyin() {
		/*
		 * add combining diacritical marks after vowels for tone marks
		 */
		char vowel = getInput().charAt(getInput().replace("[aeiou]", "\\0").indexOf("\\0"));
		switch(getInput().charAt(getInput().length()-1)){
		case '1':
			return getInput().replace("" + vowel, vowel + "" + 0x0304);
		case '2':
			return getInput().replace("" + vowel, vowel + "" + 0x0301);
		case '3':
			return getInput().replace("" + vowel, vowel + "" + 0x030C);
		case '4':
			return getInput().replace("" + vowel, vowel + "" +0x0300);
		default:
			return getInput();
		}
	}

}
