package us.loadingpleasewait.pee;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

public class PinyinExtensibleEditor implements Serializable, ActionListener {

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

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent event) {
		
	}

}
