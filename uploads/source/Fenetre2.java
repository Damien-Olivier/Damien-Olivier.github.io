import java.awt.*;
import java.awt.event.*;
 
public class Fenetre2 extends Frame { 
 public Fenetre2(String title) { 
  super(title); 
  gestEvt ge = new gestEvt(); 
  addWindowListener(ge); } 
 
 public static void main(String[] args) { 
  try { 
   Fenetre2 tf = new Fenetre2("Classe indépendante implémetant le listener"); 
   tf.setSize(500,100); tf.pack(); tf.setVisible(true);} catch (Throwable e) 
    { System.err.println("Erreur"); e.printStackTrace(System.out); } 
 } 
}

class gestEvt implements WindowListener { 
    // Implémentation de WindowListener 
 public void windowActivated(java.awt.event.WindowEvent e) {} 
 public void windowClosed(java.awt.event.WindowEvent e) {} 
 public void windowClosing(java.awt.event.WindowEvent e) { 
  System.exit(0); 
 } 
 public void windowDeactivated(java.awt.event.WindowEvent e) {} 
 public void windowDeiconified(java.awt.event.WindowEvent e) {} 
 public void windowIconified(java.awt.event.WindowEvent e) {} 
 public void windowOpened(java.awt.event.WindowEvent e) {} 
}
