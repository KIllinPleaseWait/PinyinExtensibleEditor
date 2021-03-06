package us.loadingpleasewait.pee;

import java.awt.Font;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.text.DefaultCaret;
import javax.swing.text.Document;
import javax.swing.undo.CannotUndoException;
import javax.swing.undo.UndoManager;

public class GUI extends JFrame {

	private static final long serialVersionUID = 63895785266111154L;

	private JTextArea input;
	private JTextArea output;
	private JPanel jPanel;
	private JScrollPane jScrollPane1;
	private JScrollPane jScrollPane2;
	private Font font;
	private UndoManager undo;

	/**
	 * Just a default constructor
	 */
	public GUI() {

	}

	/**
	 * Just calls super
	 * @param gc the GraphicsConfiguration
	 */
	public GUI(GraphicsConfiguration gc) {
		super(gc);
	}

	/**
	 * Just calls super
	 * @param title the title
	 * @param gc the GraphicsConfiguration
	 */
	public GUI(String title, GraphicsConfiguration gc) {
		super(title, gc);
	}

	/**
	 * Just calls super
	 * @param title the title
	 * @throws HeadlessException if graphics configuration is headless
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
		undo = new UndoManager();

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
			/* (non-Javadoc)
			 * @see java.awt.event.MouseListener#mouseClicked(java.awt.event.MouseEvent)
			 */
			@Override
			public void mouseClicked(MouseEvent event) {
				String text = output.getText();
				StringSelection stringSelection = new StringSelection(text);
				Clipboard clpbrd = Toolkit.getDefaultToolkit()
						.getSystemClipboard();
				clpbrd.setContents(stringSelection, null);
			}

			/* (non-Javadoc)
			 * @see java.awt.event.MouseListener#mousePressed(java.awt.event.MouseEvent)
			 */
			@Override
			public void mousePressed(MouseEvent event) {

			}

			/* (non-Javadoc)
			 * @see java.awt.event.MouseListener#mouseReleased(java.awt.event.MouseEvent)
			 */
			@Override
			public void mouseReleased(MouseEvent event) {

			}

			/* (non-Javadoc)
			 * @see java.awt.event.MouseListener#mouseEntered(java.awt.event.MouseEvent)
			 */
			@Override
			public void mouseEntered(MouseEvent event) {

			}

			/* (non-Javadoc)
			 * @see java.awt.event.MouseListener#mouseExited(java.awt.event.MouseEvent)
			 */
			@Override
			public void mouseExited(MouseEvent event) {

			}
		});
		output.setFont(font);
		jScrollPane1.setViewportView(output);

		input.setColumns(20);
		input.setFont(font);
		jScrollPane2.setViewportView(input);
		
		Document doc = input.getDocument();
		doc.addUndoableEditListener(new UndoableEditListener() {
		    /* (non-Javadoc)
		     * @see javax.swing.event.UndoableEditListener#undoableEditHappened(javax.swing.event.UndoableEditEvent)
		     */
		    @Override
		    public void undoableEditHappened(UndoableEditEvent event) {
		        undo.addEdit(event.getEdit());
		    }
		});

		InputMap inputMap = input.getInputMap(JComponent.WHEN_FOCUSED);
		ActionMap actionMap = input.getActionMap();

		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_Z, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()), "Undo");
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_Y, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()), "Redo");

		actionMap.put("Undo", new AbstractAction() {

			private static final long serialVersionUID = -6423096995199182203L;

			/* (non-Javadoc)
			 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
			 */
			@Override
			public void actionPerformed(ActionEvent event) {
				try {
		            if (undo.canUndo()) {
		                undo.undo();
		            }
		        } catch (CannotUndoException exp) {
		            exp.printStackTrace();
		        }
				
			}
		});
		actionMap.put("Redo", new AbstractAction() {

			private static final long serialVersionUID = -899655610183011824L;

			/* (non-Javadoc)
			 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
			 */
			@Override
		    public void actionPerformed(ActionEvent event) {
		        try {
		            if (undo.canRedo()) {
		                undo.redo();
		            }
		        } catch (CannotUndoException exp) {
		            exp.printStackTrace();
		        }
		    }
		});

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
