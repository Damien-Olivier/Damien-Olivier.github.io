import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/*
 * D'après le tutorial Sun
 */
public class RadioButtonDemo extends JPanel implements ActionListener {
    static final String[] nom = {"Oiseau", "Chat", "Chien", "Lapin", "Cochon"};
    JLabel image;
    
    public RadioButtonDemo() {
        super(new BorderLayout());
	JRadioButton[] boutons = new JRadioButton[nom.length];
	ButtonGroup group = new ButtonGroup();
	JPanel radioPanel = new JPanel(new GridLayout(0, 1));
	
	for(int i = 0; i < nom.length; i++)
	    {
		boutons[i] = new JRadioButton(nom[i]);
		boutons[i].setActionCommand(nom[i]);
		group.add(boutons[i]);
		boutons[i].addActionListener(this);
		radioPanel.add(boutons[i]);
	    }

        image = new JLabel(new ImageIcon(nom[0]+".gif"));
	boutons[0].setSelected(true);
        image.setPreferredSize(new Dimension(125, 125));
	
        add(radioPanel, BorderLayout.EAST);
        add(image, BorderLayout.CENTER);
        setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
    }

    /** Listens to the radio buttons. */
    public void actionPerformed(ActionEvent e) {
        image.setIcon(new ImageIcon(e.getActionCommand()
                                        + ".gif"));
    }


    public static void main(String s[]) { 
        JFrame frame = new JFrame("RadioButtonDemo"); 
	frame.addWindowListener(new WindowAdapter() { 
	   public void windowClosing(WindowEvent e) 
		{
		    System.exit(0);
		} 
	    }); 
	frame.getContentPane().add(new RadioButtonDemo(), BorderLayout.CENTER);
	frame.pack(); 
	frame.setVisible(true); 
    } 
} 
   
