import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JTabbedPaneEx {
    static public void main(String args[]) {
        JFrame frame = new JFrame("Onglet Demo");
        frame.addWindowListener(new WindowAdapter()
	    {
		public void windowClosing(WindowEvent e) 
		{
		    System.exit(0);
		}
	    }
				);
	// On cree un panel à onglets
        JTabbedPane onglets = new JTabbedPane();
	
	// un premier onglet
        JPanel onglet1 = new JPanel();
	JLabel label = new JLabel("Premier Onglet");
	onglet1.add(label);
	onglets.addTab("Label", null, onglet1, "Je suis le premier onglet avec un label!");
	
	// un deuxieme onglet
        JPanel onglet2 = new JPanel();
	JTextField textField = new JTextField(20);
	onglet2.add(textField);
	onglets.addTab("Champ de saisie", null, onglet2, "Je suis le deuxieme onglet avec un champ de saisie.");
	
	// On ajoutee le panel à onglet dans le panel principal
        Container contentPane = frame.getContentPane();
        contentPane.add(onglets);
	
        frame.pack();
        frame.setVisible(true);
    }
}
