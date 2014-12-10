package us.loadingpleasewait.pee;

import java.io.Serializable;

public class PinyinExtensibleEditor implements Serializable {

	private static final long serialVersionUID = -2539923325344870564L;
	
	private GUI graphics;

	/**
	 * @param args program arguments (this is not used)
	 */
	public static void main(String[] args) {
		new PinyinExtensibleEditor().start();
	}

	/**
	 * Start the PinyinExtensibleEditor
	 */
	public void start() {
		graphics = new GUI();
		graphics.initComponents();
		
		// constantly update output
		new Thread(new Runnable() {
			
			/* (non-Javadoc)
			 * @see java.lang.Runnable#run()
			 */
			@Override
			public void run() {
				while(true){
					convertInputToPinyin();
					try {
						Thread.sleep(50);
					} catch (InterruptedException ex) {
						ex.printStackTrace();
					}
				}
			}
		}).start();
	}
	
	/**
	 * Convert the input to pinyin and put the pinyin in the output text area
	 */
	public void convertInputToPinyin(){
		String[] input = graphics.getInputText().split("\\s");
		String unprocessedInput = graphics.getInputText();// will get shortened as each part is processed
		String output = "";
		for(String word : input){
			output += new Word(word).getPinyin();
			unprocessedInput = unprocessedInput.replace(word, "");
			if(!unprocessedInput.isEmpty()){
				output += unprocessedInput.charAt(0);
				unprocessedInput = unprocessedInput.substring(1);// add back in the whitespace
			}
		}
		graphics.setOutputText(output);
	}

	/**
	 * @return the graphics
	 */
	protected GUI getGraphics() {
		return graphics;
	}

	/**
	 * @param graphics the graphics to set
	 */
	protected void setGraphics(GUI graphics) {
		this.graphics = graphics;
	}

}
