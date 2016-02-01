import java.awt.*;
import java.awt.event.*;
import java.awt.GraphicsEnvironment;
import java.util.Arrays;
import javax.swing.JComboBox;
import javax.swing.JFrame;

public class AwtControlDemo extends JFrame implements ActionListener {

   private JComboBox fontComboBox;
  

   public AwtControlDemo(){
      setTitle("Font Chooser");
      setSize(500,500);
      addWindowListener(new WindowAdapter() {
    	  public void windowClosing(WindowEvent e) {
    		  System.exit(0);
      }
   });
      
  fontComboBox = new JComboBox();
  fontComboBox.setEditable(true);
  fontComboBox.addActionListener(this);
  
      GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
      String[] names = ge.getAvailableFontFamilyNames();
      for ( int i=0; i<names.length; i++ ){
    	  fontComboBox.addItem(names[i]);
    	 }
   }
   public String getFirstWord(String font){
      String[] fontName = font.split(" ", 2);
      	
      	return fontName[0];
      
   }
   public String getNextWords(String font){
	      String[] fontName = font.split(" ", 2);
	      	
	      	return fontName[1];
   }
   
   
}  