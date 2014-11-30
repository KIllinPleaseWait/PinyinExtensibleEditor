package us.loadingpleasewait.pee;


public class Word extends PinyinString {
	
	private static final long serialVersionUID = 33515391726789689L;
	
	public Word(){
		super("");
	}
	
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
		// split up each syllable and then put the string back together
		String output = "";
		for(String letters : getInput().split("\\d")){
			output += new Syllable(getInput().substring(getInput().indexOf(letters), getInput().indexOf(letters) + letters.length() + 1));
		}
		return output;
	}

}
