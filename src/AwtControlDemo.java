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
      headerLabel.setText("Dropdown menu test"); 
      GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
      String[] names = ge.getAvailableFontFamilyNames();
      
      Choice fontFamily = new Choice();
      
       
      for ( int i=0; i<names.length; i++ ){
    	  String firstWord = getFirstWord(names[i]);
    	  String b = getFirstWord(names[i-1]);
    	
    	  
    	  fontFamily.add(names[i]);
    	 
      }
      controlPanel.add(fontFamily);
      
      mainFrame.setVisible(true);  
   }

   public class fontFamilyListener implements ActionListener{
      public void actionPerformed(ActionEvent e) {
         String command = e.getActionCommand();  
         if( command.equals( "OK" ))  {
            statusLabel.setText("Ok Button clicked.");
         }
         else if( command.equals( "Submit" ) )  {
            statusLabel.setText("Submit Button clicked."); 
         }
         else  {
            statusLabel.setText("Cancel Button clicked.");
          
         }  	
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