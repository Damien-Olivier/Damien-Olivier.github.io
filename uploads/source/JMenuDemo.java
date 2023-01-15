import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

class MenuDemo extends JFrame implements ActionListener
{  
    JPanel panel;
    JMenuBar mbar;
    JMenu m1, m2, m3;
    JPopupMenu popup;
    
    public MenuDemo()
    { 
	setTitle("Test de JMenu & Co");
	setSize(300,200);
	
	// gestion evenementielle de la fermeture de la fenêtre
	addWindowListener(new WindowAdapter()
	    {public void windowClosing(WindowEvent e)
		{System.exit(0);
		}
	    } ) ;
        
	// utilisation d'un toolkit pour l'affichage
        // d'une icone associée à la fenêtre
	Toolkit tk = Toolkit.getDefaultToolkit();
        Image JFrameIcon = tk.getImage("icon.gif");
        setIconImage(JFrameIcon);
	
        // insertion d'objets graphiques sur la fenêtre
        // à partir d'un panneau
        panel = new JPanel();
        Container contentPane = getContentPane();
        panel.setBackground(Color.blue);
        contentPane.add(panel);

        // Ajout d'une barre de menus à la fenêtre
        mbar = new JMenuBar();
        m1 = new JMenu("Couleur fond");
        JMenuItem m11 = new JMenuItem("Jaune");
        m11.addActionListener(this); // installation d'un écouteur d'action
        m1.add(m11);  // ajout d'une option à un menu
        JMenuItem m12 = new JMenuItem("Rouge");
        m12.addActionListener(this);
        m1.add(m12);
        m2 = new JMenu("Couleur menu");
        JMenuItem m21 = new JMenuItem("Bleu");
        m21.addActionListener(this);
        m2.add(m21);
        JMenuItem m22 = new JMenuItem("Vert");
        m22.addActionListener(this);
        m2.add(m22);

	m3 = new JMenu("Autre");
	JMenuItem menuItem = new JMenuItem("Texte", KeyEvent.VK_T);
	menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.ALT_MASK));
	menuItem.setActionCommand("text");
        menuItem.addActionListener(this);
	m3.add(menuItem);
	menuItem = new JMenuItem("Texte et image", new ImageIcon("up.gif"));
	menuItem.setMnemonic(KeyEvent.VK_B);
	menuItem.setActionCommand("text-image");
	menuItem.addActionListener(this);
	m3.add(menuItem);
	menuItem =new JMenuItem(new ImageIcon("left.gif"));
	menuItem.addActionListener(this);
	m3.add(menuItem);

	// Groupe de boutons radio
	m3.addSeparator();
	ButtonGroup group = new ButtonGroup();
	JRadioButtonMenuItem rbMenuItem =
	    new JRadioButtonMenuItem("Un choix bouton radio");
	rbMenuItem.setSelected(true);
	rbMenuItem.setMnemonic(KeyEvent.VK_R);
	group.add(rbMenuItem);
	rbMenuItem.addActionListener(this);
	m3.add(rbMenuItem);
	rbMenuItem = new JRadioButtonMenuItem("Autre choix");
	rbMenuItem.setMnemonic(KeyEvent.VK_A);
	group.add(rbMenuItem);
	rbMenuItem.addActionListener(this);
	m3.add(rbMenuItem);
	
	// Case à cocher
	m3.addSeparator();
	JCheckBoxMenuItem cbMenuItem = new JCheckBoxMenuItem("Un boîte à cocher");
	cbMenuItem.setMnemonic(KeyEvent.VK_C);
	cbMenuItem.addActionListener(this);
	m3.add(cbMenuItem);
	cbMenuItem = new JCheckBoxMenuItem("Une autre");
	cbMenuItem.setMnemonic(KeyEvent.VK_U);
	cbMenuItem.addActionListener(this);
	m3.add(cbMenuItem);

        // Un sous-menu
	m3.addSeparator();
	JMenu submenu = new JMenu("Un sous-menu");
	submenu.setMnemonic(KeyEvent.VK_S);
	menuItem = new JMenuItem("Un choix du sous-menu");
	menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2, ActionEvent.ALT_MASK));
	menuItem.addActionListener(this);
	submenu.add(menuItem);
	m3.add(submenu);

	// Création d'un menu popup
	popup = new JPopupMenu();
	menuItem = new JMenuItem("Un choix du menu popup");
	menuItem.addActionListener(this);
	popup.add(menuItem);
	menuItem = new JMenuItem("Autre choix");
	menuItem.addActionListener(this);
	popup.add(menuItem);


	// Ajoute un écouteur qui affiche le menu popup
	// aux composants qui pourront afficher ce menu
	panel.addMouseListener(new MouseAdapter()
	    { public void mousePressed(MouseEvent e)
		{
		    if (e.isPopupTrigger())
			{
			    popup.show(e.getComponent(), e.getX(), e.getY());
			}
		}		
	    }
);

	mbar.add(m1);  // ajout de menus à la barre de menus
        mbar.add(m2);
	mbar.add(m3);
        setJMenuBar(mbar);
     }

  public void actionPerformed(ActionEvent evt){  
      if (evt.getSource()instanceof JMenuItem) 
	  // gestion des événements liés aux menus
	  { String ChoixOption = evt.getActionCommand();
	  if (ChoixOption.equals("Jaune"))panel.setBackground(Color.yellow);
	  else if (ChoixOption.equals("Rouge"))panel.setBackground(Color.red);
	  else if (ChoixOption.equals("Bleu"))
	      {mbar.setBackground(Color.blue);
	      m1.setBackground(Color.blue);
	      m2.setBackground(Color.blue);
	      } 
	  else if (ChoixOption.equals("Vert"))
	      {mbar.setBackground(Color.green);
	      m1.setBackground(Color.green);
	      m2.setBackground(Color.green);
	      };
	  };
      	  System.out.println(evt.getActionCommand());
  }

}

 public class JMenuDemo
 { public static void main(String[] args)
    {JFrame f =new MenuDemo();
     f.setVisible(true);
     }
 }
