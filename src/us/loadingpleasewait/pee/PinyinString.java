package us.loadingpleasewait.pee;

import java.io.Serializable;

public abstract class PinyinString implements Serializable {
	
	private static final long serialVersionUID = -5863790379845113502L;
	
	private String input;
	
	/**
	 * calls setInput
	 * @param input input String
	 */
	public PinyinString(String input) {
		setInput(input);
	}

	/**
	 * @return the input
	 */
	public String getInput() {
		return input;
	}

	/**
	 * trims and sets input
	 * @param input the input to set
	 */
	public void setInput(String input) {
		this.input = input.trim();
	}

	/**
	 * @return the string in pinyin
	 */
	public abstract String getPinyin();

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return getPinyin();
	}
}
