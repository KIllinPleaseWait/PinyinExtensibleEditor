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
		// find out which vowel to put a tone on
		char vowel;
		if(getInput().contains("a")){
			vowel = 'a';
		}else if(getInput().contains("e")){
			vowel = 'e';
		}else if(getInput().contains("i")){
			vowel = 'i';
		}else if(getInput().contains("o")){
			vowel = 'o';
		}else if(getInput().contains("u")){
			if(getInput().charAt(getInput().length()-1) >= '5'){
				// add 5 to tone number to use u with umlaut
				vowel = 'ü';
				setInput(getInput().substring(0, getInput().length()-1) + (char)(getInput().charAt(getInput().length()-1) - 5));
				setInput(getInput().replace('u', vowel));
			}else{
				vowel = 'u';
			}
		}else{
			return getInput();// no vowel no tone mark
		}
		
		// add combining diacritical marks after vowels for tone marks
		switch(getInput().charAt(getInput().length()-1)){
		case '1':
			return getInput().replace("" + vowel, vowel + "" + (char) 0x0304).substring(0, getInput().length());// flat tone
		case '2':
			return getInput().replace("" + vowel, vowel + "" + (char) 0x0301).substring(0, getInput().length());// upward tone
		case '3':
			return getInput().replace("" + vowel, vowel + "" + (char) 0x030C).substring(0, getInput().length());// v tone
		case '4':
			return getInput().replace("" + vowel, vowel + "" + (char) 0x0300).substring(0, getInput().length());// downward tone
		default:
			return getInput();// no valid tone number
		}
	}

}
