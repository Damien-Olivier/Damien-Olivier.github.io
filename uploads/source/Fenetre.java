import java.awt.*;
import java.awt.event.*;

public class Fenetre extends Frame implements WindowListener {
  public Fenetre() {
    setSize(400, 300);
  } 
  public void windowClosing(WindowEvent event) {
    System.exit(0);
  }
  public void windowClosed(WindowEvent event) {}
  public void windowDeiconified(WindowEvent event) {}
  public void windowIconified(WindowEvent event) {}
  public void windowActivated(WindowEvent event) {}
  public void windowDeactivated(WindowEvent event) {}
  public void windowOpened(WindowEvent event) {}
	
  public static void main(String arg[]) {
    Fenetre Test = new Fenetre();
    Test.setTitle("ma fenetre JAVA");
    Test.setVisible(true);
    Test.addWindowListener(Test);
  }
}
