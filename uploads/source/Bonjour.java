import javax.swing.*;

public class Bonjour extends JFrame {
 public Bonjour() {
  super("Thread et Swing");
  setDefaultCloseOperation(EXIT_ON_CLOSE);
  getContentPane().add(new JLabel("Bonjour à tous!", JLabel.CENTER));
  pack();
  setVisible(true);
 }
 
 public static void main(String[] args) {
  new Bonjour();
  System.out.println("C'est la dernière instruction du main() et pourtant ....");
 }
}

