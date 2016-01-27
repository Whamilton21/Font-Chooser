import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.tools.JavaFileManager.Location;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;


public class fontSelector extends Applet
{
	JPanel panel;
	JFrame frame;
	
	public fontSelector() {
		setSize(800,800);
		init();
	
	}
	
	public void init() {
		frame = new JFrame();
		frame.setVisible(true);
		frame.setSize(800, 800);
		frame.setLocation( 100, 100);
		panel = new JPanel();
		frame.add(panel);
		JLabel label = new JLabel("What font?");
		JLabel label2 = new JLabel("What color font?");
		JLabel label3 = new JLabel("What do you want for a background color?");
		panel.add(label2);
		panel.add(label3);
		panel.add(label);
		label.setLocation(100,100);
		label2.setLocation(300, 300);
		label3.setLocation(500, 500);
		label2.setVisible(true);
		label3.setVisible(true);
		label.setVisible(true);
		System.out.println(label.getX());
		System.out.println(label.getY());
		System.out.println(label2.getY());
		String[] choices = {"Times New Roman", "Arial", "Cabria"};
		String[] choices2 = {"Blue", "Red", "Green", "Yellow", "Orange"};
		String[] choices3 = {"Grey", "Silver", "Black", "White"};
		final JComboBox<String> fontChooser = new JComboBox<String>(choices);
		fontChooser.setVisible(true);
		fontChooser.setLocation(100, 100);
		panel.add(fontChooser);
		JButton selectFont = new JButton("Select");
		panel.add(selectFont);
	}
	
}
