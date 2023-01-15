// Time-stamp: <Extended.java   8 Mar 2004 10:56:23>

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Exemple  Mod�le/Vue/Contr�leur d'apr�s J. Berstel
 * Ajout d'un bouton "Remise � z�ro" et d'un champ de saisie 
 * @version 2.0
 */
class Extended {
    // Commandes possibles
    final String incrAction = "INCR"; // Incr�mentation de la donn�e
    final String decrAction = "DECR"; // D�cr�mentation de la donn�e
    final String zeroAction = "ZERO"; // Mise � z�ro de la donn�e
    final String setoAction = "SETO"; // Nouvelle valeur pour la donn�e

    // Architecture Mod�le/Vue/Contr�leur
    // ATTENTION : le contr�leur doit �tre contruit avant la vue
    // pour qu'il puisse �tre �couteur des composants de la vue.
    private Model model = new Model();	 
    private Controller controller = new Controller(); 
    private View view = new View();
    
    public Extended() {
	// Affichage de la vue
	view.setVisible(true);
    }

    public static void main(String [] args)
    {
	// Cr�ation 
	Extended ext = new Extended();
    }

    /** Vue affichant les donn�es */
    class View extends JFrame {
	final int width  = 150;	// Largeur de la fen�tre
	final int height = 100;	// Hauteur de la fen�tre
	JLabel label;		// Affichage de la donn�e
	View() {
	    // Constructeur avec titre
	    super("Plus ou moins �tendu");
	    // Dimension de la fen�tre
	    setSize(width, height);
	    // Action � faire lorsque la fen�tre est ferm�e.
	    setDefaultCloseOperation(EXIT_ON_CLOSE);
	    // Cr�ation du champ d'affichage de la valeur
	    label = new JLabel(Integer.toString(model.getValue()), 
			       JLabel.CENTER);
	    // Cr�ation des boutons
	    JButton resetButton = new JButton("Remise � z�ro");
	    resetButton.setActionCommand(zeroAction);
	    resetButton.addActionListener(controller);
	    JButton plusButton = new JButton("+");
	    plusButton.setActionCommand(incrAction);
	    plusButton.addActionListener(controller);
	    JButton moinsButton = new JButton("-");
	    moinsButton.setActionCommand(decrAction);
	    moinsButton.addActionListener(controller);
	    // Cr�ation du champ de saisie
	    JTextField textField = new JTextField(10);
	    textField.setActionCommand(setoAction);
	    textField.addActionListener(controller);
	    // Mise en place des �l�ments dans un panneau
	    JPanel mainPanel = (JPanel) getContentPane();
	    mainPanel.setLayout(new BorderLayout());
	    mainPanel.add(resetButton, "North");
	    mainPanel.add(plusButton, "East");
	    mainPanel.add(label, "Center");
	    mainPanel.add(moinsButton, "West");
	    mainPanel.add(textField, "South");
	}
	// Mise � jour de l'affichage � partir des donn�es du mod�le
	void update() {
	    label.setText(Integer.toString(model.getValue()));
	}
    }

    /** Contr�leur */
    class Controller implements ActionListener {
	// Action sur reception d'un �v�nement
	public void actionPerformed(ActionEvent event) {
	    String command = event.getActionCommand();
	    // Switch pas tr�s esth�tique mais assez in�vitable avec
	    // l'architecture MVC.
	    if (command == incrAction) 
		model.incrValue(+1);
	    else if (command == decrAction) 
		model.incrValue(-1);
	    else if (command == zeroAction) 
		model.setValue(0);
	    else if (command == setoAction) {
		JTextField textField = (JTextField) event.getSource();
		// Texte saisi par l'utilisateur
		String text = textField.getText();
		// Tentative d'extraire un entier du texte
		try {
		    model.setValue(Integer.parseInt(text));
		}
		// En cas d'�chec, pas d'action
		catch (NumberFormatException e) {}
	    }
	    // Force la vue � �tre conforme aux donn�es
	    view.update();
	}
    }
}

/** Mod�le des donn�es */
class Model {
    // Les donn�es sont constitu�es d'un seul entier.
    private int value;		// Donn�es du mod�le
    Model(int value) { this.value = value; }
    Model() { this(0); }
    void setValue(int value) { this.value = value; }
    void incrValue(int incr) { value += incr; }
    int getValue() { return value; }
}


