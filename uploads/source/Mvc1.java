// Time-stamp: <Mvc.java   9 mar 2003 18:26:56>

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Exemple PlusOuMoins en Model/View/Controler d'apr�s J. Bertel
 * @version 1.0
 */
class Mvc {
    public Mvc() {
	// Cr�ation du mod�le
	Model model = new Model();
	// Cr�ation du contr�leur
	Controler controler = new Controler(model);
	// Cr�ation de la vue
	View view = new View(model, controler);
	controler.setView(view);
	// Affichage de la vue
	view.setVisible(true);
    }

    public static void main(String [] args)
    {
	// Cr�ation 
	Mvc mvc = new Mvc();
    }
}

/**
 * Bouton avec valeur incr�mentale
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
 * Mod�le contenant les donn�es
 * Les donn�es sont constitu�es d'un seul entier.
 */
class Model {
    private int value;		// Donn�es du mod�le
    Model(int value) { this.value = value; }
    Model() { this(0); }
    void incrValue(int incr) { value += incr; }
    int getValue() { return value; }
}

/**
 * Vue affichant les donn�es
 */
class View extends JFrame {
    final int width  = 150;	// Largeur de la fen�tre
    final int height = 20;	// Hauteur de la fen�tre
    Model model;		// Mod�le contenant les donn�es
    JLabel label;		// �tiquette d'affichage
    View(Model model, Controler controler) {
	// Constructeur avec titre
	super("Plus ou moins");
	// Initialisation du mod�le
	this.model = model;
	// Dimension de la fen�tre
	setSize(width, height);
	// Action � faire lorsque la fen�tre est ferm�e.
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	// Cr�ation du champ d'affichage de la valeur
	label = new JLabel(Integer.toString(model.getValue()), JLabel.CENTER);
	// Cr�ation des deux Boutons �cout�s par label
	JButton plusButton = new IncrButton("+", +1);
	plusButton.addActionListener(controler);
	JButton moinsButton = new IncrButton("-", -1);
	moinsButton.addActionListener(controler);
	// Mise en place des �l�ments dans un panneau
	JPanel mainPanel = (JPanel) getContentPane();
	mainPanel.setLayout(new BorderLayout());
	mainPanel.add(plusButton, "East");
	mainPanel.add(label, "Center");
	mainPanel.add(moinsButton, "West");
    }
    // Mise � jour de l'affichage � partir des donn�es du mod�le
    void update() {
	label.setText(Integer.toString(model.getValue()));
    }
}

/**
 * Contr�leur 
 */
class Controler implements ActionListener {
    Model model;		// Mod�le contenant les donn�es 
    View view;			// Vue des donn�es
    Controler(Model model) { this.model = model; }
    void setView(View view) { this.view = view; }
    // Action sur reception d'un �v�nement
    public void actionPerformed(ActionEvent event) {
	// Bouton �metteur de l'�v�nement
	IncrButton button = (IncrButton) event.getSource();
	// Mise � jour des donn�es
	model.incrValue(button.getIncr());
	// Force la vue � �tre conforme aux donn�es
	view.update();
    }
}
