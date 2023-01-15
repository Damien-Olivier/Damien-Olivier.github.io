import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Fenetre extends JFrame
{
    ActionPartagee copyAction, cutAction, pasteAction;

/*
  Creation d'une classe qui herite de AbstractAction.
  On l'utilise ensuite comme ActionListener dans des
  objets derivant de AbstractButton
*/
    class ActionPartagee extends AbstractAction
    {
	String nom;
	public ActionPartagee(String n)
	{
	    super(n);
	    nom = n;
	}
	
	public void actionPerformed(ActionEvent e)
	{
	    if (e.getActionCommand().equals("Coller"))
		{
		    cutAction.setEnabled(true);
		    copyAction.setEnabled(true);
		    pasteAction.setEnabled(false);
		}
	    else pasteAction.setEnabled(true);
	}
    }

    public Fenetre()
    {
	setTitle("Demonstration actions communes");
	setSize(300,300);
	addWindowListener(new WindowAdapter()
	    {
		public void windowClosing(WindowEvent e)
		{
		    System.exit(0);
		}
	    });

	JPanel panel = new JPanel();
        Container contentPane = getContentPane();
        contentPane.add(panel);
	
	JMenuBar menu = new JMenuBar();
	JToolBar toolBar = new JToolBar();
	JMenu edition = new JMenu("Edition");
	
	copyAction = new ActionPartagee("Copier");
	cutAction = new ActionPartagee("Couper");
	pasteAction = new ActionPartagee("Coller");
	pasteAction.setEnabled(false);

	edition.add(new JMenuItem(copyAction));
	edition.add( new JMenuItem(cutAction));
	edition.add(new JMenuItem(pasteAction));
	
	menu.add(edition); 

	toolBar.add(new JButton(copyAction));
	toolBar.add(new JButton(cutAction));
	toolBar.add(new JButton(pasteAction));
	panel.add(toolBar);
	
	setJMenuBar(menu);
    }
}



public class DemoActionPartagees
{
    public static void main(String[] s)
    {
	Fenetre f = new Fenetre();
	f.setVisible(true);
    }
}
        

    
