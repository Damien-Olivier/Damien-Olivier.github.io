import java.awt.*;
import java.awt.event.*;
 
public class Fenetre1 extends Frame implements WindowListener { 
 public Fenetre1(String title) { 
  super(title); 
  this.addWindowListener(this); 
 } 

 public static void main(java.lang.String[] args) { 
  try { 
   Fenetre1 tf = new Fenetre1("Fenetre implémentant elle même le listener");
   tf.setSize(500,100);
   tf.pack();
   tf.setVisible(true); 
  } catch (Throwable e) 
    { 
     System.err.println("Erreur"); 
     e.printStackTrace(System.out); 
    } 
 }

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
