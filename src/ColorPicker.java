
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ColorPicker extends JFrame {

  public ColorPicker() {
    super("ColorChooser Test Frame");
    setSize(200, 100);
    final Container contentPane = getContentPane();
    final JButton go = new JButton("Show ColorChooser");
    go.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        Color c;
        c = JColorChooser.showDialog(
                  ((Component)e.getSource()).getParent(),
                  "Demo", Color.blue);
        contentPane.setBackground(c); 
      }
    });
    contentPane.add(go, BorderLayout.SOUTH);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
  }

  public static void main (String args[]) {
    ColorPicker cp = new ColorPicker();
    cp.setVisible(true);
  }
}

