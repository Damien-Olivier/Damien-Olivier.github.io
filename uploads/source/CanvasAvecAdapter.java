import java.awt.*; 
import java.awt.event.*;



class UnCanvasCliquable2 extends Canvas
{ 
    int nbClick = 0;

    class gestionClick extends MouseAdapter {
	public void mouseClicked(MouseEvent e) { 
	    nbClick++; repaint(); 
	} 
    }

    public UnCanvasCliquable2() { 
	super(); 
	addMouseListener(new gestionClick());
    }

    public void paint(Graphics g) { 
	super.paint(g); 
	g.drawString("Nombre de clics : "+nbClick,10,10);
 
    }
}


public class CanvasAvecAdapter  { 
    
    static public void main (String arg [ ]) {  
	Frame w = new Frame("Essai canvas"); 
	Canvas c = new UnCanvasCliquable2();
	c.setSize(new Dimension(150,150)); 
	w.add("Center",c); 
	w.setSize(200,200); 
	w.pack();w.setVisible(true); 
	c.paint(c.getGraphics());
    }
}
