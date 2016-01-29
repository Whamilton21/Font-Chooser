import java.awt.*;
import java.awt.event.*;
import java.awt.GraphicsEnvironment;
import java.util.Arrays;

public class AwtControlDemo {

   private Frame mainFrame;
   private Label headerLabel;
   private Label statusLabel;
   private Panel controlPanel;

   public AwtControlDemo(){
      prepareGUI();
   }

   public static void main(String[] args){
	   AwtControlDemo  awtControlDemo = new AwtControlDemo();
       awtControlDemo.showEventDemo();
   }

   public void prepareGUI(){
      mainFrame = new Frame("Java AWT Examples");
      mainFrame.setSize(400,400);
      mainFrame.setLayout(new GridLayout(3, 1));
      mainFrame.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent windowEvent){
            System.exit(0);
         }        
      });    
      headerLabel = new Label();
      headerLabel.setAlignment(Label.CENTER);
      statusLabel = new Label();        
      statusLabel.setAlignment(Label.CENTER);
      statusLabel.setSize(350,100);

      controlPanel = new Panel();
      controlPanel.setLayout(new FlowLayout());

      mainFrame.add(headerLabel);
      mainFrame.add(controlPanel);
      mainFrame.add(statusLabel);
      mainFrame.setVisible(true);  
   }

   public void showEventDemo(){
      headerLabel.setText(""); 
      GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
      String[] names = ge.getAvailableFontFamilyNames();
      
      Choice fontFamily = new Choice();
      Choice fontStyle  = new Choice();
       
      for ( int i=0; i<names.length; i++ ){
    	  
    	  fontFamily.add(names[i]);
    	 
      }
      
      fontStyle.add("Bold");
      fontStyle.add("Underline");
      fontStyle.add("Italic");
      
      controlPanel.add(fontFamily);
      controlPanel.add(fontStyle);
      
      mainFrame.setVisible(true);  
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