import java.awt.*; 
import java.awt.event.*; 
import javax.swing.*;

public class JCheckBoxDemo extends JPanel implements ActionListener { 
    protected JCheckBox b1, b2, b3; 
    
    public JCheckBoxDemo() { 
 
	b1 = new JCheckBox("Solaris"); 
	b2 = new JCheckBox("Linux");
	b2.setSelected(true);  // Du parti-pris !
	b3 = new JCheckBox("Windows"); 

	b1.addActionListener(this);
	b2.addActionListener(this);
	b3.addActionListener(this); 

	b1.setToolTipText("Sun is for you"); 
	b2.setToolTipText("Unix for all"); 
	b3.setToolTipText("Microsoft is looking you");

	//On ajoute les composants (FlowLayout) 
	add(b1); add(b2); add(b3); 
    } 
    
    public void actionPerformed(ActionEvent e) { 
	if (e.getSource() == b3) 
	    {  
		b1.setSelected(false);
		b2.setSelected(false);
	    } 
	else b3.setSelected(false); 	
	System.out.println(e.getActionCommand());
    } 
    
    public static void main(String[] args) { 
	JFrame frame = new JFrame("JCheckBox Démo"); 
	frame.addWindowListener(new WindowAdapter() { 
		public void windowClosing(WindowEvent e) { 
		    System.exit(0); 
		} 
	    }); 
	frame.add(new JCheckBoxDemo(), BorderLayout.CENTER); 
	frame.pack(); 
	frame.setVisible(true); 
    } 
}










/*

public class TestJCheckBox1 { public static void main(String argv[]) { JFrame f = new JFrame("ma fenetre"); f.setSize(300,100); JPanel pannel = new JPanel(); JCheckBox bouton1 = new JCheckBox("Bouton 1"); pannel.add(bouton1); JCheckBox bouton2 = new JCheckBox("Bouton 2"); pannel.add(bouton2); JCheckBox bouton3 = new JCheckBox("Bouton 3"); pannel.add(bouton3); f.getContentPane().add(pannel); f.setVisible(true); } }*/
