import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// On d�rive JPanel
class SimplePanel extends JPanel {

  // 2 composants un champ texte, un bouton
  JTextField textField;
  JButton button;
  
  //
  public SimplePanel() {

    // Create a JButton
    button = new JButton("Effacer");
    
    // On ajoute le JButton au JPanel
    add(button);
    
    // JTextField (10 colonnes)
    textField = new JTextField(10);
    
    // On ajoute le JTextField au JPanel
    add(textField);

    // On ajoute le listener au JButton
    // On efface
    button.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        textField.setText("");
      }
    });
  }
}
    


// Une fen�tre
public class SimplePanelTest extends JFrame {

  // Largeur hauteur de la fen�tre
  static final int WIDTH = 300;
  static final int HEIGHT = 100;

  SimplePanelTest(String title) {
    super(title);
    
    SimplePanel simplePanel = new SimplePanel();
    Container c = getContentPane();
    c.add(simplePanel, BorderLayout.CENTER);
  }
      
  public static void main(String args[]) {

    JFrame frame = 
      new SimplePanelTest("SimplePanel Example");
    
    // Fin du monde
    frame.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });
    
    // On d�finit la taille de la fen�tre et on l'affiche
    frame.setSize(WIDTH, HEIGHT);
    frame.setVisible(true);
  }   
}
