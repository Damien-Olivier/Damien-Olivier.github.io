import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JComboBoxDemo extends JPanel implements ItemListener
{  
  JComboBox choix =new JComboBox();
  Ardoise ardoise = new Ardoise();
 
  JComboBoxDemo()
  {
    JPanel panneau = new JPanel();

    choix.addItem("noir");
    choix.addItem("rouge");
    choix.addItem("vert");
    choix.addItem("bleu");
    choix.addItem("jaune");
    choix.addItemListener(this);
    panneau.add(choix);
    setLayout(new BorderLayout(5, 5));
    add(panneau, BorderLayout.NORTH);
    add(ardoise, BorderLayout.CENTER);
  }
  
  public void itemStateChanged(ItemEvent evt)  
    {  
      ardoise.setForeground
	(getCouleur((String)choix.getSelectedItem()));
    }
  
  Color getCouleur(String s)
    {
      if (s.equals("noir")) return Color.black;
      else if (s.equals("rouge")) return Color.red;
      else if (s.equals("vert")) return Color.green;
      else if (s.equals("bleu")) return Color.blue;
      else if (s.equals("jaune")) return Color.yellow;
      return Color.black;
    }
  
  public static void main(String[] argv)
    {
      JFrame monCadre = new JFrame();
      monCadre.setContentPane(new JComboBoxDemo());
      monCadre.addWindowListener(new WindowAdapter()
	      	 {
		   public void windowClosing(WindowEvent e)
		     { 
		       System.exit(0);  
		     }
		 });
      monCadre.pack();
      monCadre.setVisible(true);
    }
}

class Ardoise extends JPanel
{
  Ardoise()
    {
      setPreferredSize(new Dimension(100, 100));
    }

  public  void paintComponent(Graphics g)
  {
    super.paintComponent(g);
    g.drawOval(10,10,80,80);
    g.fillOval(10,10,80,80);
  }
}
