import java.awt.*; 
import java.awt.event.*;

class UnCanvas4 extends Canvas implements MouseMotionListener
{ 
    private int x;  
    private int y;

    public UnCanvas4() { 
	super(); 
	addMouseMotionListener(this);
    }

    public void paint(Graphics g) { 
	super.paint(g); 
	g.drawString("x = "+x+" ; y = "+y,20,20); }
    
    public void mouseDragged(MouseEvent e) {}
    public void mouseMoved(MouseEvent e) { 
	x = e.getX(); y = e.getY(); 
	repaint();
    }
}

public class GestionEvenement4  { 
    
    static public void main (String arg [ ]) {  
	Frame w = new Frame("Essai canvas"); 
	Canvas c = new UnCanvas4();
	c.setSize(new Dimension(200,200)); 
	w.add("Center",c); 
	w.setSize(200,200); 
	w.pack(); w.setVisible(true); 
	c.paint(c.getGraphics());
    }
}
