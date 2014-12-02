package us.loadingpleasewait.pee;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class GUI extends JFrame{

	private static final long serialVersionUID = 63895785266111154L;
	private JTextArea InputArea;
    private JTextArea OutputArea;
    private JPanel jPanel;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;

	public GUI() {
        initComponents();
    }
	
	private void initComponents() {

        jPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        OutputArea = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        InputArea = new javax.swing.JTextArea();

        setTitle("Pinyin Extensible Editor");
		setSize(800, 500);
		setVisible(true);
		setResizable(false); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        OutputArea.setColumns(20);
        jScrollPane1.setViewportView(OutputArea);

        InputArea.setColumns(20);
        jScrollPane2.setViewportView(InputArea);

        GroupLayout jPanelLayout = new GroupLayout(jPanel);
        jPanel.setLayout(jPanelLayout);
        jPanelLayout.setHorizontalGroup(
            jPanelLayout.createParallelGroup(Alignment.LEADING)
            .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
            .addGroup(jPanelLayout.createParallelGroup(Alignment.LEADING)
                .addComponent(jScrollPane2))
        );
        jPanelLayout.setVerticalGroup(
            jPanelLayout.createParallelGroup(Alignment.LEADING)
            .addGroup(Alignment.TRAILING, jPanelLayout.createSequentialGroup()
                .addGap(225, 225, 225)
                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
            .addGroup(jPanelLayout.createParallelGroup(Alignment.LEADING)
                .addGroup(jPanelLayout.createSequentialGroup()
                    .addGap(25, 25, 25)
                    .addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                    ))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
            .addComponent(jPanel)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
            .addComponent(jPanel)
        );

        pack();
    }
}
