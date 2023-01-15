import java.awt.*; 

class UnCanvas extends Canvas 
{ 
    public void paint(Graphics g) { 
	g.setColor(Color.black); 
	g.fillRect(10, 10, 100,50); 
	g.setColor(Color.green); 
	g.fillOval(40, 40, 10,10); 
    }
}

public class TestCanvas  { 
    
    static public void main (String arg [ ]) {  
	Frame w = new Frame("Essai canvas"); 
	Canvas c = new UnCanvas();
	c.setSize(new Dimension(200,200)); 
	w.add("Center",c); 
	w.setSize(200,120); 
	w.setVisible(true); 
	c.paint(c.getGraphics());
    }
}
