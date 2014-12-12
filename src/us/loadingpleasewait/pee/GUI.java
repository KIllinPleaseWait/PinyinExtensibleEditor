package us.loadingpleasewait.pee;

import java.awt.Font;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import javax.swing.text.DefaultCaret;

public class GUI extends JFrame {

	private static final long serialVersionUID = 63895785266111154L;

	private JTextArea input;
	private JTextArea output;
	private JPanel jPanel;
	private JScrollPane jScrollPane1;
	private JScrollPane jScrollPane2;
	private Font font;

	/**
	 * Just a default constructor
	 */
	public GUI() {

	}

	/**
	 * @param gc
	 */
	public GUI(GraphicsConfiguration gc) {
		super(gc);
	}

	/**
	 * @param title
	 * @param gc
	 */
	public GUI(String title, GraphicsConfiguration gc) {
		super(title, gc);
	}

	/**
	 * @param title
	 * @throws HeadlessException
	 */
	public GUI(String title) throws HeadlessException {
		super(title);  
	}

	public void initComponents() {

		UIManager.put("TextArea.margin", new Insets(10, 10, 10, 10));
		jPanel = new JPanel();
		jScrollPane1 = new JScrollPane();
		output = new JTextArea();
		jScrollPane2 = new JScrollPane();
		input = new JTextArea();
		font = new Font(Font.SANS_SERIF, Font.PLAIN, 20);

		setTitle("PinyinExtensibleEditor");
		setSize(800, 500);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		output.setColumns(20);
		output.setEditable(false);
		DefaultCaret caret = (DefaultCaret)output.getCaret();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		output.addMouseListener(new MouseListener() {
			/**
			 * @param Copies
			 *            text to clipboard when you click at the output
			 *            textArea
			 */
			@Override
			public void mouseClicked(MouseEvent event) {
				String text = output.getText();
				StringSelection stringSelection = new StringSelection(text);
				Clipboard clpbrd = Toolkit.getDefaultToolkit()
						.getSystemClipboard();
				clpbrd.setContents(stringSelection, null);
			}

			@Override
			public void mousePressed(MouseEvent event) {

			}

			@Override
			public void mouseReleased(MouseEvent event) {

			}

			@Override
			public void mouseEntered(MouseEvent event) {

			}

			@Override
			public void mouseExited(MouseEvent event) {

			}
		});
		output.setFont(font);
		jScrollPane1.setViewportView(output);

		input.setColumns(20);
		input.setFont(font);
		jScrollPane2.setViewportView(input);

		GroupLayout jPanelLayout = new GroupLayout(jPanel);
		jPanel.setLayout(jPanelLayout);
		jPanelLayout.setHorizontalGroup(jPanelLayout
				.createParallelGroup(Alignment.LEADING)
				.addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 700,
						Short.MAX_VALUE)
				.addGroup(
						jPanelLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(jScrollPane2)));
		jPanelLayout
				.setVerticalGroup(jPanelLayout
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								Alignment.TRAILING,
								jPanelLayout
										.createSequentialGroup()
										.addGap(225, 225, 225)
										.addComponent(jScrollPane1,
												GroupLayout.PREFERRED_SIZE,
												200, GroupLayout.PREFERRED_SIZE)
										.addGap(25, 25, 25))
						.addGroup(
								jPanelLayout
										.createParallelGroup(Alignment.LEADING)
										.addGroup(
												jPanelLayout
														.createSequentialGroup()
														.addGap(25, 25, 25)
														.addComponent(
																jScrollPane2,
																GroupLayout.PREFERRED_SIZE,
																200,
																GroupLayout.PREFERRED_SIZE))));

		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup().addComponent(
				jPanel));
		layout.setVerticalGroup(layout.createParallelGroup().addComponent(
				jPanel));

		input.setLineWrap(true);
		output.setLineWrap(true);
		jScrollPane1
				.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		jScrollPane2
				.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		pack();
	}

	/**
	 * Adds the specified focus listener to receive focus events from the input
	 * textfield
	 * 
	 * @param listener
	 *            the focus listener to be added
	 */
	public void addInputFocusListener(FocusListener listener) {
		input.addFocusListener(listener);
	}

	/**
	 * set the text of the output text area
	 * 
	 * @param text
	 *            text that to put in the output text area
	 */
	public void setOutputText(String text) {
		output.setText(text);
	}

	/**
	 * get the input text
	 * 
	 * @return the text in the input text area
	 */
	public String getInputText() {
		return input.getText();
	}

	/**
	 * @return the input
	 */
	protected JTextArea getInput() {
		return input;
	}

	/**
	 * @param input
	 *            the input to set
	 */
	protected void setInput(JTextArea input) {
		this.input = input;
	}

	/**
	 * @return the output
	 */
	protected JTextArea getOutput() {
		return output;
	}

	/**
	 * @param output
	 *            the output to set
	 */
	protected void setOutput(JTextArea output) {
		this.output = output;
	}

	/**
	 * @return the jPanel
	 */
	protected JPanel getjPanel() {
		return jPanel;
	}

	/**
	 * @param jPanel
	 *            the jPanel to set
	 */
	protected void setjPanel(JPanel jPanel) {
		this.jPanel = jPanel;
	}

	/**
	 * @return the jScrollPane1
	 */
	protected JScrollPane getjScrollPane1() {
		return jScrollPane1;
	}

	/**
	 * @param jScrollPane1
	 *            the jScrollPane1 to set
	 */
	protected void setjScrollPane1(JScrollPane jScrollPane1) {
		this.jScrollPane1 = jScrollPane1;
	}

	/**
	 * @return the jScrollPane2
	 */
	protected JScrollPane getjScrollPane2() {
		return jScrollPane2;
	}

	/**
	 * @param jScrollPane2
	 *            the jScrollPane2 to set
	 */
	protected void setjScrollPane2(JScrollPane jScrollPane2) {
		this.jScrollPane2 = jScrollPane2;
	}

}
