import java.awt.*; 
import java.awt.event.*; 

class UneFenetre3 extends Frame implements TextListener
{ 
    public UneFenetre3() 
    { 
	super();
	setSize(100,100);
	TextField t = new TextField("",30);
	t.addTextListener(this); 
	add(t); 
    } 
    
    public void textValueChanged(TextEvent txt) 
    { 
	Object source = txt.getSource(); 
	String texte = ((TextField)source).getText(); 
	System.out.println("Texte : "+ texte); 
    } 
}


public class GestionEvenement3
{
    public static void main(String[] arg)
    {
	UneFenetre3 f = new UneFenetre3();
	f.setVisible(true);
    }
}
