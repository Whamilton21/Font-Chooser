import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class MainProject extends JFrame implements ActionListener {
	String message = "<html>"
			+ "The quick brown fox jumped over the lazy dog’s back.<br>"
			+ "Pack my box with five dozen liquor jugs.<br>"
			+ "Jackdaws love my big sphinx of quartz.<br>"
			+ "Mr. Jock, TV quiz PhD, bags few lynx.<br>"
			+ "abcdefghijklmnopqrstuvwxyz<br>"
			+ "ABCDEFGHIJKLMNOPQRSTUVWXYZ<br>"
			+ "01234567890<br>"
			+ "€†™´¸¢©¤°÷½¼¾>¡¿«‘’<¯µ ·¬ªº¶±£\"»®§­¹²³ß×™\\¨¥<br>"
			+ "ÀÁÂÃÄÅÆÇÈÉ ÊËÌÍÎÏÐÑÒÓÔ ÕÖØÙÚÛÜÝÞÿ<br>"
			+ "àáâãäåæçèé êëìíîïðñòóô õöøùúûüýþÿ<br>"
			+ "!\"#$%&'()*+,-./:;<=>?@[\\^_z{|}~<br>"
			+ "uvw wW gq9 2z 5s il17|!j oO08 `'\" ;:,. m nn rn {[()]}u\");<br>"
			+ "</html>";
					
	
			JLabel fontLabel = new JLabel(message);
      

  private JComboBox fontPicker;
  int tsize = 12;
  String tfont = "Arial";
  
  private JButton Button1 = new JButton("Text Color");
  private JButton Button2 = new JButton ("Background Color");

 


  public MainProject() { 
    setTitle("Choose Your Font, Color, and Background");
    setSize(1250, 1000);
    addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });
    
    

    fontPicker = new JComboBox();
    fontPicker.addActionListener(this);
    
    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
    String[] names = ge.getAvailableFontFamilyNames();
    for ( int i=0; i<names.length; i++ )
    {
       fontPicker.addItem(names[i]);
    }

    
    Button1.addActionListener(new ButtonListener());
    Button2.addActionListener(new ButtonListener());
   
   
    setLayout(null);
    JPanel p = new JPanel();
    JPanel f = new JPanel();
    JPanel b = new JPanel();
    
    p.add(fontPicker);
    
   
    f.add(Button1);
    b.add(Button2);
   
    
    getContentPane().add(p);
    p.setBounds(45, 100, 300, 100);
    getContentPane().add(f);
    f.setBounds(52,200,150,50);
    getContentPane().add(b);
    b.setBounds(75, 250, 150, 50);
    getContentPane().add(fontLabel);
    fontLabel.setBounds(400,200,700,500);
  }


  
  
  public void actionPerformed(ActionEvent evt) {
    JComboBox source = (JComboBox) evt.getSource();

    if (source == fontPicker) 
    {
    	String font = (String) source.getSelectedItem();
    	fontLabel.setFont(new Font(font, Font.PLAIN, tsize));
    	tfont = font;
    }
  }
 
  public static void main(String[] args) {
    JFrame frame = new MainProject();
    frame.show();
  }

  private class ButtonListener implements ActionListener {
	    public void actionPerformed(ActionEvent e) {
	    	  JButton src = (JButton) e.getSource();

	    	    if (src == Button1) 
	    	    {
	    	    	 Color c = JColorChooser.showDialog(null, "Choose the Color of Your Font", fontLabel.getForeground());
	    		      if (c != null)
	    		        fontLabel.setForeground(c);
	    	    }
	    	    if (src == Button2)
	    	    {
	    	    	 Color b = JColorChooser.showDialog(null, "Choose the Background Color", fontLabel.getBackground());
	    		      if (b != null)
	    		    	  fontLabel.setBackground(b);
	    		      	fontLabel.setOpaque(true);
	    	    }
	  
}
  }
}  