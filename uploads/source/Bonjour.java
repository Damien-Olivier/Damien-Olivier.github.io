import javax.swing.*;

public class Bonjour extends JFrame {
 public Bonjour() {
  super("Thread et Swing");
  setDefaultCloseOperation(EXIT_ON_CLOSE);
  getContentPane().add(new JLabel("Bonjour � tous!", JLabel.CENTER));
  pack();
  setVisible(true);
 }
 
 public static void main(String[] args) {
  new Bonjour();
  System.out.println("C'est la derni�re instruction du main() et pourtant ....");
 }
}

