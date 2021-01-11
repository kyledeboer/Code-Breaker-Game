import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class InstructionsGUI extends JFrame{
	private JFrame dataJFrame = new JFrame();
	InstructionsGUI(){
		
		super("Instructions");
		
		final JTextArea textbox;
		textbox = new JTextArea();
		JScrollPane textbox1=new JScrollPane(textbox);
		setLayout(new BorderLayout());
		add("Center", textbox1);
		textbox.setText("Stand in for instructions\n\nbreak the code\n\ndont run out of attempts");
		setVisible(true);
		setSize(800, 600);
	}
}
