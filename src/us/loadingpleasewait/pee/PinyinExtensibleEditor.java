package us.loadingpleasewait.pee;

import java.awt.BorderLayout;
import java.io.Serializable;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PinyinExtensibleEditor implements Serializable{

	private static final long serialVersionUID = -2539923325344870564L;

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		JTextField output = new JTextField("1");
		JTextField input = new JTextField("2");
		JPanel panel = new JPanel();
		
		frame.setTitle("Pinyin Extensible Editor");
		frame.setSize(800, 500);
		frame.setVisible(true);
		frame.setResizable(true); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel.setLayout(new BorderLayout());
		
		panel.add(input);
		output.setEditable(false);
		panel.add(output);
		frame.add(panel);
	}

}
