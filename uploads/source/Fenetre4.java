import java.awt.*;
import java.awt.event.*;
 
public class Fenetre4 extends Frame { 
    public Fenetre4(String title) {
	super(title);
	addWindowListener(
			  new WindowAdapter() { 
			      public void windowClosing(WindowEvent e) { 
				  System.exit(0); 
			      } 
			  }
			  ); 
    } 
 
    public static void main(String[] args) { 
	try { 
	    Fenetre4 tf = new Fenetre4("Classe anonyme"); 
	    tf.setSize(500,100); tf.pack(); tf.setVisible(true);
	} catch (Throwable e) 
	    { System.err.println("Erreur"); e.printStackTrace(System.out); } 
    } 
}


