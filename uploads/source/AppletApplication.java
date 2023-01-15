import java.applet.*; 
import java.awt.*; 
import java.awt.event.*; 
public class AppletApplication extends Applet implements WindowListener { 
 public static void main(java.lang.String[] args) { 
  AppletApplication applet = new AppletApplication(); 
  Frame frame = new Frame("Applet"); 
  frame.addWindowListener(applet); 
  frame.add("Center", applet); 
  frame.setSize(350, 250); 
  frame.setVisible(true); 
  applet.init();
  applet.start(); 
 } 
 
/* public void init() {
  Frame frame = new Frame("Applet"); 
  frame.setSize(350, 250); 
  frame.setVisible(true); 
}*/
 public void paint(Graphics g) { 
  super.paint(g); 
  g.drawString("Bonjour", 10, 10); 
 } 
 public void windowActivated(WindowEvent e) { } 
 public void windowClosed(WindowEvent e) { } 
 public void windowClosing(WindowEvent e) { System.exit(0); } 
 public void windowDeactivated(WindowEvent e) { } 
 public void windowDeiconified(WindowEvent e) { } 
 public void windowIconified(WindowEvent e) { } 
 public void windowOpened(WindowEvent e) { } 
}
