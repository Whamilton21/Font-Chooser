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
import javax.swing.JTextArea;

//set up text area with pangrams we were given
public class MainProject extends JFrame implements ActionListener {
	String message = "\nThe quick brown fox jumped over the lazy dog’s back.\n"
			+ "Pack my box with five dozen liquor jugs.\n"
			+ "Jackdaws love my big sphinx of quartz.\n"
			+ "Mr. Jock, TV quiz PhD, bags few lynx.\n"
			+ "abcdefghijklmnopqrstuvwxyz\n"
			+ "ABCDEFGHIJKLMNOPQRSTUVWXYZ\n"
			+ "01234567890<br>"
			+ "€†™´¸¢©¤°÷½¼¾>¡¿«‘’<¯µ ·¬ªº¶±£\"»®§­¹²³ß×™\\¨¥\n"
			+ "ÀÁÂÃÄÅÆÇÈÉ ÊËÌÍÎÏÐÑÒÓÔ ÕÖØÙÚÛÜÝÞÿ\n"
			+ "àáâãäåæçèé êëìíîïðñòóô õöøùúûüýþÿ\n"
			+ "!\"#$%&'()*+,-./:;<=>?@[\\^_z{|}~\n"
			+ "uvw wW gq9 2z 5s il17|!j oO08 `'\" ;:,. m nn rn {[()]}u\");\n";
					
	
			JTextArea fontArea = new JTextArea(message);
      
//create classes for drop down menus and buttons
  public JComboBox fontPicker;
  int tsize = 12;
  String tfont = "Arial";
  
  public JComboBox fontStyle;
  
  public JButton Button1 = new JButton("Text Color");
  
  public JButton Button2 = new JButton ("Background Color");

  //Set up window of GUI
  public MainProject() { 
    setTitle("Choose Your Font, Color, and Background");
    setSize(900, 500);
    addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });
    
    
//create JComboBox of the font families and one of font styles
    fontPicker = new JComboBox();
    JComboBox fontStyle = new JComboBox();
    
    String regular = "-";
    String bold = "Bold";
    String italics = "Italics";
    //populate menu of font styles
    fontStyle.addItem(regular);
    fontStyle.addItem(bold);
    fontStyle.addItem(italics);
    //populate menu of font familes present on machine
    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
    String[] names = ge.getAvailableFontFamilyNames();
    for ( int i=0; i<names.length; i++ )
    {
       fontPicker.addItem(names[i]);
    }
//add listeners for the buttons and menus created
    fontPicker.addActionListener(this);
    fontStyle.addActionListener(this);
    Button1.addActionListener(new ButtonListener());
    Button2.addActionListener(new ButtonListener());
   
 //create panels  
    setLayout(null);
    JPanel p = new JPanel();
    JPanel f = new JPanel();
    JPanel b = new JPanel();
   //add buttons and menus to panels
    p.add(fontPicker);
    p.add(fontStyle);
    f.add(Button1);
    b.add(Button2);
   
   //set dimensions of panels 
    getContentPane().add(p);
    p.setBounds(45, 100, 300, 100);
    getContentPane().add(f);
    f.setBounds(52,200,150,50);
    getContentPane().add(b);
    b.setBounds(75, 250, 150, 50);
    getContentPane().add(fontArea);
    fontArea.setBounds(400,100,400,250);
  }
//create listener to change the font of pangrams based on drop down menu
  public void actionPerformed(ActionEvent evt) {
    JComboBox source = (JComboBox) evt.getSource();
    
    if (source == fontPicker) 
    {
    	String font = (String) source.getSelectedItem();
    	
    	fontArea.setFont(Font.decode(font));
  
    }
//checks which style is selected and changes the font based on it 
    if (source == fontStyle){
    	String regular = "-";
        String bold = "Bold";
        String italics = "Italics";
    	
        if (fontStyle.getSelectedItem() == regular){
			
			Font fonts = fontArea.getFont();  
			
			fontArea.setFont(fonts.deriveFont(Font.PLAIN));
        }
        
		if (fontStyle.getSelectedItem() == bold){
			
			Font fonts = fontArea.getFont();  
			
			fontArea.setFont(fonts.deriveFont(Font.BOLD));
		}
    	if (fontStyle.getSelectedItem() == italics){
    		Font fonts = fontArea.getFont();
    		
    		fontArea.setFont(fonts.deriveFont(Font.ITALIC));
    	}
    }
    	}
    	
  
 
//build GUI
public static void main(String[] args) {
    JFrame frame = new MainProject();
    frame.show();
  }
//set up listener for the color choosers
  public class ButtonListener implements ActionListener {
	    public void actionPerformed(ActionEvent e) {
	    	  JButton src = (JButton) e.getSource();

	    	    if (src == Button1) 
	    	    {
	    	    	 Color c = JColorChooser.showDialog(null, "Choose the Color of Your Font", fontArea.getForeground());
	    		      if (c != null)
	    		        fontArea.setForeground(c);
	    	    }
	    	    if (src == Button2)
	    	    {
	    	    	 Color b = JColorChooser.showDialog(null, "Choose the Background Color", fontArea.getBackground());
	    		      if (b != null)
	    		    	  fontArea.setBackground(b);
	    		      	fontArea.setOpaque(true);
	    	    }
	  
}
  }
}  