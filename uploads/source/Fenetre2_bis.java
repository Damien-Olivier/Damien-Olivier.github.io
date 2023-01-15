import java.awt.*;
import java.awt.event.*;
 
public class Fenetre2_bis extends Frame { 
 public Fenetre2_bis(String title) { 
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


class gestEvt extends WindowAdapter { 
 public void windowClosing(java.awt.event.WindowEvent e) { 
  System.exit(0); 
 } 
}
