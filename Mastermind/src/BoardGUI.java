import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Scrollbar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class BoardGUI extends JFrame{
	//private GridLayout grid = new GridLayout(12,10);
	JFrame f = new JFrame();
	
	public BoardGUI() {
		
		setSize(1650,1080);
		setExtendedState(JFrame.MAXIMIZED_BOTH); 
		setUndecorated(true);
		setVisible(true);
		getContentPane().setBackground(new java.awt.Color(204, 166, 166));
		//JPanel panel = new JPanel();
		//GridLayout grid = new GridLayout(12,10);
		
		JPanel hints = new JPanel(new GridLayout(12,5));
		JPanel guess = new JPanel(new GridLayout(12,5));
		
		
	}
}
