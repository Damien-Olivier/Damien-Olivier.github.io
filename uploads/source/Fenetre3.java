import java.awt.*;
import java.awt.event.*;
 
public class Fenetre3 extends Frame {
 class gestEvt implements WindowListener {  
  public void windowActivated(java.awt.event.WindowEvent e) {} 
  public void windowClosed(java.awt.event.WindowEvent e) {} 
  public void windowClosing(java.awt.event.WindowEvent e) { System.exit(0); } 
  public void windowDeactivated(java.awt.event.WindowEvent e) {} 
  public void windowDeiconified(java.awt.event.WindowEvent e) {} 
  public void windowIconified(java.awt.event.WindowEvent e) {} 
  public void windowOpened(java.awt.event.WindowEvent e) {} 
 }

 private gestEvt ge = new Fenetre3.gestEvt();
 
 public Fenetre3(String title) { 
  super(title); 
  addWindowListener(ge); } 
 
 public static void main(String[] args) { 
  try { 
   Fenetre3 tf = new Fenetre3("Classe interne implémetant le listener"); 
   tf.setSize(500,100); tf.pack(); tf.setVisible(true);} catch (Throwable e) 
    { System.err.println("Erreur"); e.printStackTrace(System.out); } 
 } 
}


