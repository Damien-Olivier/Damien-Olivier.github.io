import java.awt.*; 
import java.awt.event.*;

class UnCanvasCliquable extends Canvas implements MouseListener
{ 
    private int xPrec = -1;
    private int yPrec;  
    int nbClick = 0;
    public UnCanvasCliquable() { 
	super(); 
	addMouseListener(this);
    }

    public void paint(Graphics g) { 
	super.paint(g); 
	g.drawString("Nombre de clics : "+nbClick,10,10);
 
    }

    public void mouseClicked(MouseEvent e) { 
	nbClick++;
 	clic(e.getX(), e.getY());
	//repaint();
    } 
    public void mouseEntered(MouseEvent e) {} 
    public void mouseExited(MouseEvent e) {} 
    public void mousePressed(MouseEvent e) {} 
    public void mouseReleased(MouseEvent e) {}
   
    private void clic(int x, int y) { 
      if (xPrec >= 0) { 
            Graphics g = getGraphics(); 
            g.drawLine(xPrec, yPrec, x, y); 
      } 
      xPrec = x; yPrec = y;
    }
}

public class GestionEvenementNv  { 
    
    static public void main (String arg [ ]) {  
	Frame w = new Frame("Essai canvas"); 
	Canvas c = new UnCanvasCliquable();
	c.setSize(new Dimension(200,200)); 
	w.add("Center",c); 
	w.setSize(200,200); 
	w.pack();w.setVisible(true); 
//	c.paint(c.getGraphics());
    }
}
