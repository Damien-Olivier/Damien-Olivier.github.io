import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*; 

public class ToolBarDemo extends JFrame { 
    private JTextArea textArea; 
    private JButton[] button = new JButton[3];
    
    private class BoutonListener implements ActionListener{
	final static String message = "Action sur le bouton ";
	public void actionPerformed(ActionEvent e) { 
	    int i = 0;
	    while (i < 3 && e.getSource() != button[i]) i++;	    
	    if (i < 3) 
		textArea.append(message+(++i)+"\n");
	    else  textArea.append("Ouille"+"\n");
	}
    } 

    public ToolBarDemo() { 
	super("Demo de ToolBar"); 
	addWindowListener(new WindowAdapter() 
	    { 
		public void windowClosing(WindowEvent e) { 
		    System.exit(0); 
		} 
	    }); 
	//Creation de la ToolBar
	JToolBar toolBar = new JToolBar();
	// On ajoute les boutons à la toolBar
	addButtons(toolBar); 
	//Creation de zone de texte pour les sorties
	textArea = new JTextArea(5, 30); 
	JScrollPane scrollPane = new JScrollPane(textArea);
	//Lay out 
	JPanel contentPane = new JPanel();
	contentPane.setLayout(new BorderLayout()); 
	contentPane.setPreferredSize(new Dimension(400, 100)); 
	contentPane.add(toolBar, BorderLayout.NORTH); 
	contentPane.add(scrollPane, BorderLayout.CENTER); 
	setContentPane(contentPane); 
    } 
    
    protected void addButtons(JToolBar toolBar) { 
	// Le premier bouton
	button[0] = new JButton( new ImageIcon("left.gif")); 
	button[0].setToolTipText("Ceci est le bouton gauche");
 	button[0].addActionListener(new BoutonListener()); 
	toolBar.add(button[0]); 
	// Le deuxième bouton 
	button[1] = new JButton( new ImageIcon("up.gif")); 
	button[1].setToolTipText("Ceci est le bouton du milieu"); 
	button[1].addActionListener(new BoutonListener()); 
	toolBar.add(button[1]);
	toolBar.addSeparator();
	// Le troisième bouton
	button[2] = new JButton( new ImageIcon("right.gif")); 
	button[2].setToolTipText("Ceci est le bouton de droite"); 
	button[2].addActionListener(new BoutonListener());
	toolBar.add(button[2]); 
    } 

    public static void main(String[] args) { 
	ToolBarDemo frame = new ToolBarDemo(); 
	frame.pack(); 
	frame.setVisible(true); 
    } 
}
  
