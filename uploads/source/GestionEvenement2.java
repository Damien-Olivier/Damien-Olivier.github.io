import java.awt.*; 
import java.awt.event.*; 

class UneFenetre2 extends Frame implements ItemListener
{ 
    public UneFenetre2() 
    { 
	super();
	setSize(100,100);
	Choice c = new Choice();
	c.add("choix 1"); 
	c.add("choix 2"); 
	c.add("choix 3"); 
	c.addItemListener(this); 
	add(c); 
    } 
    
    public void itemStateChanged(ItemEvent item) 
    { 
	Object obj = item.getItem(); 
	String selection = (String)obj; 
	System.out.println("choix : "+selection); 
    } 
}


public class GestionEvenement2
{
    public static void main(String[] arg)
    {
	UneFenetre2 f = new UneFenetre2();
	f.setVisible(true);
    }
}
