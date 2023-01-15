import java.awt.*; 
import java.awt.event.*;
import java.util.*;

class UnCanvasCliquable extends Canvas implements MouseListener
{ 
    int nbClick = 0;
    public UnCanvasCliquable() { 
	super(); 
	addMouseListener(this);
    }

    private ArrayList<Point> points  = new ArrayList<Point>(); 
    public void paint(Graphics g) { 
      super.paint(g); 
      g.drawString("Nombre de clics : "+nbClick,10,10);
      Iterator it = points.iterator(); 
      if (it.hasNext()) { 
        Point p = (Point) it.next(); 
        while (it.hasNext()) { 
          Point q = (Point) it.next(); 
          g.drawLine(p.x, p.y, q.x, q.y); p = q;
	}
      } 
    }
    
    public void mouseClicked(MouseEvent e) { 
	nbClick++;
        points.add(new Point(e.getX(), e.getY()));
	repaint();
    } 
    public void mouseEntered(MouseEvent e) {} 
    public void mouseExited(MouseEvent e) {} 
    public void mousePressed(MouseEvent e) {} 
    public void mouseReleased(MouseEvent e) {}
}

public class GestionEvenementNv2  { 
    
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
