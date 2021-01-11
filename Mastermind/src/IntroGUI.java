import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;


public class IntroGUI extends JFrame{
	private JButton start,instructions,quit;
	JFrame f = new JFrame();
	
	public IntroGUI(String name) {
		
		super(name);
		setLayout(new BorderLayout());
		setSize(1650,1080);
		setExtendedState(JFrame.MAXIMIZED_BOTH); 
		setUndecorated(true);
		
		JLabel title= new JLabel("CODE BREAKER",SwingConstants.CENTER);
		title.setFont(new Font("Serif", Font.BOLD, 90));
		getContentPane().setBackground(new java.awt.Color(204, 166, 166));
		add("Center",title);
		
		start = new JButton("Start");
		instructions = new JButton("Instructions");
		quit = new JButton("Quit");
		JPanel subPanel=new JPanel();
		subPanel.add(start);
		subPanel.add(instructions);
		subPanel.add(quit);
		add("South",subPanel);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		start.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent event) {
				
				BoardGUI boardGUI = new BoardGUI();
				setVisible(false);
			}
		
		});
		
		instructions.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent event) {
				
				InstructionsGUI inst = new InstructionsGUI();
		
			}
		
		});
		
		quit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event) {
				System.exit(1);
			}
		
		});
	}
}
