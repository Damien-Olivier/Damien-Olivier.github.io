import java.awt.*; 
import java.awt.event.*; 
import javax.swing.*; 

public class BoutonDemo extends JPanel implements ActionListener { 
    protected JButton b1, b2, b3; 
    
    public BoutonDemo() { 
	ImageIcon leftButtonIcon = new ImageIcon("right.gif"); 
	ImageIcon middleButtonIcon = new ImageIcon("up.gif"); 
	ImageIcon rightButtonIcon = new ImageIcon("left.gif");
 
	b1 = new JButton("Desactive le milieu", leftButtonIcon); 
	b1.setVerticalTextPosition(AbstractButton.CENTER); 
	b1.setHorizontalTextPosition(AbstractButton.LEFT); 
	b1.setMnemonic(KeyEvent.VK_D); //ALT D
	b1.setActionCommand("desactive"); 

	b2 = new JButton("Bouton du milieu", middleButtonIcon); 
	b2.setVerticalTextPosition(AbstractButton.BOTTOM); 
	b2.setHorizontalTextPosition(AbstractButton.CENTER); 
	b2.setMnemonic(KeyEvent.VK_M);
 
	b3 = new JButton("Active le milieu", rightButtonIcon); 
	// Utilise la position du texte par défaut CENTER, RIGHT. 
	b3.setMnemonic(KeyEvent.VK_E); 
	b3.setActionCommand("active"); 
	b3.setEnabled(false);

	//Ecouteurs pour 1 and 3. 
	b1.addActionListener(this); 
	b3.addActionListener(this); 

	b1.setToolTipText("Cliquez sur ce boutton pour désactiver le milieu"); 
	b2.setToolTipText("Ne fait rien quand on clique"); 
	b3.setToolTipText("Cliquez sur ce bouton pour activer le milieu");

	//On ajoute les composants (FlowLayout) 
	add(b1); add(b2); add(b3); 
    } 
    
    public void actionPerformed(ActionEvent e) { 
	if (e.getSource() == b1) 
	    {
		b2.setEnabled(false); 
		b1.setEnabled(false); 
		b3.setEnabled(true); 
	    } 
	else 
	    { 
		b2.setEnabled(true); 
		b1.setEnabled(true); 
		b3.setEnabled(false); 
	    } 
	System.out.println(e.getActionCommand());
    } 
    
    public static void main(String[] args) { 
	JFrame frame = new JFrame("Varicelle"); 
	frame.addWindowListener(new WindowAdapter() { 
		public void windowClosing(WindowEvent e) { 
		    System.exit(0); 
		} 
	    }); 
	frame.getContentPane().add(new BoutonDemo());
//, BorderLayout.CENTER); 
	frame.pack(); 
	frame.setVisible(true); 
    } 
}
