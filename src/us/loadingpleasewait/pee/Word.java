package us.loadingpleasewait.pee;


public class Word extends PinyinString {
	
	private static final long serialVersionUID = 33515391726789689L;
	
	/**
	 * Sets the input as empty
	 */
	public Word(){
		super("");
	}
	
	/**
	 * Calls super to set the input
	 * @param input the input string
	 */
	public Word(String input) {
		super(input);
	}

	/* (non-Javadoc)
	 * @see us.loadingpleasewait.pee.PinyinString#getPinyin()
	 */
	@Override
	public String getPinyin() {
		if(getInput().replaceAll("\\d", "").equals(getInput()) || getInput().replaceAll("\\d", "").isEmpty())
			return getInput();//just return input if the input is all numbers or no numbers
		String unprocessedInput = getInput();
		// split up each syllable and then put the string back together
		String output = "";
		for(String letters : getInput().split("\\d")){
			try{
				output += new Syllable(unprocessedInput.substring(unprocessedInput.indexOf(letters), unprocessedInput.indexOf(letters) + letters.length() + 1).toLowerCase());
			}catch(StringIndexOutOfBoundsException ex){
				output += letters;// no pinyin to convert
			}
			unprocessedInput = unprocessedInput.replace(letters, "");
		}
		// capitalize first letter if it is capitalized in the input
		String firstLetter = getInput().substring(0, 1);
		if(firstLetter.toUpperCase().equals(firstLetter))
			output = output.substring(0, 1).toUpperCase() + output.substring(1, output.length());
		return output;
	}

}
