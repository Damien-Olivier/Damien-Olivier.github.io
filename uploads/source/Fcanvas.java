import java.awt.*; 

class EssaiCanvas extends Canvas { 

  public void paint (Graphics g){ 
 g.fillOval(50,30,5,5); 
 g.drawString("50*30",57,36); 

 g.fillOval(10,50,5,5); 
 g.drawString("10*50",17,56); 

 g.drawRect(10,60,120,30); 
 g.drawString("rectangle",11,70); 
 g.drawString("position : 10*60",11,80); 
 g.drawString("dimension : 120*30",11,90); 
  } 
} 


public class Fcanvas  { 

static public void main (String arg [ ]) { 
 Frame w = new Frame("Essais canvas"); 
 Canvas c = new EssaiCanvas(); 
 c.setSize(new Dimension(200,200)); 
     w.add("Center",c); 
 w.setSize(200,120); 
     w.setVisible(true); 
 c.paint(c.getGraphics()); 
 } 
}
