// Time-stamp: <PlusOuMoins.java   4 Mar 2005 09:19:10>

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Exemple PlusOuMoins d'apr�s J. Bertel
 * @version 1.0
 */
class PlusOuMoins extends JFrame {
    final int width  = 150;	// Largeur de la fen�tre
    final int height = 20;	// Hauteur de la fen�tre
     public PlusOuMoins() {
	// Constructeur avec titre
	super("Plus ou moins");
	// Dimension de la fen�tre
	setSize(width, height);
	// Action � faire lorsque la fen�tre est ferm�e.
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	// Cr�ation du label
	ListenerLabel label = new ListenerLabel();
	// Cr�ation des deux Boutons �cout�s par label
	JButton plusButton = new IncrButton("+", +1);
	plusButton.addActionListener(label);
	JButton moinsButton = new IncrButton("-", -1);
	moinsButton.addActionListener(label);
	// Mise en place des �l�ments dans un panneau
	JPanel mainPanel = new JPanel(new BorderLayout());
	mainPanel.add(plusButton,BorderLayout.EAST );
	mainPanel.add(label,BorderLayout.CENTER );
	mainPanel.add(moinsButton, BorderLayout.WEST);
	// Mise en place du panneau comme contentPane de la fen�tre
	setContentPane(mainPanel);
    }

    public static void main(String [] args)
    {
	// Cr�ation de la fen�tre
	PlusOuMoins mainFrame = new PlusOuMoins();
	// Affichage de la fen�tre
	mainFrame.setVisible(true);
    }
}

/**
 * Bouton avec valeur incr�mentale incorpor�e
 */
class IncrButton extends JButton {
    private int incr;		// Valeur de l'incr�ment
    IncrButton(String title, int incr) {
	// Constructeur avec titre
	super(title);
	// Initialisation de l'incr�ment
	this.incr = incr;
    }
    int getIncr() { return incr; }
}
    

/**
 * �tiquette �coutant les boutons 
 */
class ListenerLabel extends JLabel implements ActionListener {
    int value = 0;
    ListenerLabel () {
	// Constructeur avec titre
	// Il serait pr�f�rable d'�crire :
	// super(Integer.toString(value), JLabel.CENTER);
	// mais ce n'est pas possible car le champ value
	// ne peut pas �tre utilis� dans l'appel au 
	// constructeur de la classe m�re.
	super("0", JLabel.CENTER);
    }
    public void actionPerformed(ActionEvent event) {
	IncrButton button = (IncrButton) event.getSource();
	value += button.getIncr();
	setText(Integer.toString(value));
    }
}
