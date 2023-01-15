// Time-stamp: <Bases.java   6 Jul 2003 13:08:47>

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
 * Convertisseur entre bases 
 * @author O. Carton
 * @version 1.0
 */
class Bases {
    // Architecture Mod�le/Vue/Contr�leur
    // ATTENTION : le contr�leur doit �tre construit avant la vue
    // pour qu'il puisse �tre �couteur des composants de la vue.
    private Model model = new Model();	 
    private Controller controller = new Controller(); 
    private View view = new View();
    
    public Bases() {
	// Mise en place 
	view.pack();
	// Affichage de la vue
	view.setVisible(true);
    }

    public static void main(String [] args)
    {
	// Cr�ation 
	Bases bases = new Bases();
    }

    /** Vue regroupant plusieurs vues partielles */
    class View extends JFrame {
	// Vues partielles dans diff�rentes bases
	BaseView binView = new BaseView(2);
	BaseView octView = new BaseView(8);
	BaseView decView = new BaseView(10);
	BaseView hexView = new BaseView(16);
	// Vue partielle avec des curseurs
	SliderView sliderView = new SliderView();
	// Vue partielle avec des boutons � cocher
	CheckBoxView checkBoxView = new CheckBoxView();

	// Construction de la vue globale
	View() {
	    // Constructeur avec titre
	    super("Conversion de bases");
	    // Action � faire lorsque la fen�tre est ferm�e.
	    setDefaultCloseOperation(EXIT_ON_CLOSE);

	    // Paneau des �tiquettes
	    JPanel labelPanel = new JPanel(new GridLayout(0,1));
	    labelPanel.add(new JLabel("Binaire :", JLabel.LEFT));
	    labelPanel.add(new JLabel("Octal :", JLabel.LEFT));
	    labelPanel.add(new JLabel("D�cimal :", JLabel.LEFT));
	    labelPanel.add(new JLabel("Hexad�cimal :", JLabel.LEFT));
		
	    // Paneau des zones de saisies  
	    JPanel fieldPanel = new JPanel(new GridLayout(0,1));
	    fieldPanel.add(binView);
	    fieldPanel.add(octView);
	    fieldPanel.add(decView);
	    fieldPanel.add(hexView);

	    // Panneau avec les vues par curseurs et boutons � cocher
	    JPanel bottomPanel = new JPanel();
	    bottomPanel.setLayout(new BoxLayout(bottomPanel, 
						BoxLayout.Y_AXIS));
	    bottomPanel.add(checkBoxView);
	    // Espace vertical entre les deux vues
	    bottomPanel.add(Box.createVerticalStrut(10));
	    bottomPanel.add(sliderView);
		
	    // Mise en place des �l�ments dans un panneau
	    JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
	    // Bords du panneau principal
	    mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
	    mainPanel.add(labelPanel, BorderLayout.WEST);
	    mainPanel.add(fieldPanel, BorderLayout.CENTER);
	    mainPanel.add(bottomPanel, BorderLayout.SOUTH);
	    
	    // Mise en place du panneau principal
	    setContentPane(mainPanel);
	}
	// Mise � jour de la vue
	void update() {
	    // Mise � jour des diff�rentes vues partielles
	    binView.update();
	    octView.update();
	    decView.update();
	    hexView.update();
	    sliderView.update();
	    checkBoxView.update();
	}
	/** Vue partielle dans une base */
	class BaseView extends JTextField implements ActionListener {
	    int base;		// Base d'affichage et de saisie
	    BaseView(int base) {
		// 16 colonnes au d�part
		super(16);	
		this.base = base;
		// Ce composant s'�coute lui-m�me
		addActionListener(this);
		// Mise � jour de l'affichage
		update();
	    }
	    public void actionPerformed(ActionEvent event) {
		// Tentative de d�coder la saisie
		try {
		    // Notification au contr�leur de la saisie
		    controller.notify(Integer.parseInt(getText(), base));
		}
		// Erreur de format
		catch (NumberFormatException exception) {
		    // Signal sonore
		    Toolkit.getDefaultToolkit().beep(); 
		}
	    }
	    // Mise � jour de la vue
	    void update() {
		// Mise � jour de l'affichage
		setText(Integer.toString(model.getValue(), base));
	    }
	}
	/** Vue partielle avec deux curseurs */
	class SliderView extends JPanel implements ChangeListener {
	    // Ce bool�en bloque l'envoie des �v�nements lorsque
	    // ces �v�nements sont d�s � une mise � jour des curseurs
	    private boolean eventEnable = false;
	    private JSlider lowByteSlider; // Poids faible
	    private JSlider higByteSlider; // Poids fort
	    // Construction d'un curseur pour un octet
	    private JSlider getSlider() {
		// Construction du curseur
		JSlider slider = new JSlider(0, 255);
		// Affichage du 0 et du 255
		slider.setMajorTickSpacing(255);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		// �coute du curseur par la vue partielle
		slider.addChangeListener(this);
		return slider;
	    }
	    SliderView() {
		// Gestionnaire de disposition
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		// Curseur de l'octet de poids faible
		lowByteSlider = getSlider();
		// Bord avec un titre
		lowByteSlider.setBorder(
		  BorderFactory.createTitledBorder("Octet de poids faible"));
		// Mise en place du curseur dans le panneau
		add(lowByteSlider);
		
		// Curseur de l'octet de poids fort
		higByteSlider = getSlider();
		// Bord avec un titre
		higByteSlider.setBorder(
		  BorderFactory.createTitledBorder("Octet de poids fort"));
		// Mise en place du curseur dans le panneau
		add(higByteSlider);

		// Mise � jour de l'affichage
		update();
	    }
	    // �coute des deux curseurs
	    public void stateChanged(ChangeEvent event) {
		if (eventEnable) {
		    // La valeur calcul�e � partir des deux curseurs
		    // est envoy�e au contr�leur
		    controller.notify(lowByteSlider.getValue() +
				      higByteSlider.getValue()*256
				      );
		}
	    }
	    // Mise � jour des deux curseurs
	    void update() {
		// Valeur � visualiser
		int value = model.getValue();
		eventEnable = false; // Bloquage des �v�nements
		lowByteSlider.setValue(value%256); // Poids faible
		higByteSlider.setValue(value/256); // Poids fort
		eventEnable = true;  // D�bloquage des �v�nements
	    }
	}
	/** Vue partielle avec des boutons � cocher */
	class CheckBoxView extends JPanel implements ActionListener {
	    // Nombre de boutons dans la vue
	    final int checkBoxNbr = 16;	
	    // Cr�ation du tableau de boutons
	    // Le bouton � la position i dans le tableau correspond
	    // au bit i de l'entier, c'est-�-dire celui de valeur 2^i.
	    JCheckBox[] checkBoxList = new JCheckBox[checkBoxNbr];
	    CheckBoxView() {
		// Gestionnaire de disposition : 2 lignes
		// 1 ligne pour chaque octet
		setLayout(new GridLayout(2,0));

		// Panneau contenant les boutons de l'octet de poids faible
		// Boutons sur une seule ligne
		JPanel lowBytePanel = new JPanel(new GridLayout(1,0));
		add(lowBytePanel);
		// Bord avec titre
		lowBytePanel.setBorder(BorderFactory.createTitledBorder("Octet de poids faible"));

		// Panneau contenant les boutons de l'octet de poids fort
		// Boutons sur une seule ligne
		JPanel higBytePanel = new JPanel(new GridLayout(1,0));
		add(higBytePanel);
		// Bord avec titre
		higBytePanel.setBorder(BorderFactory.createTitledBorder("Octet de poids fort"));

		// Cr�ation des boutons en partant des bits de poids forts
		for(int i = checkBoxNbr-1; i >= 0; i--) {
		    // Cr�ation du bouton
		    checkBoxList[i] = new JCheckBox();
		    // La vue partielle �coute les boutons
		    checkBoxList[i].addActionListener(this);
		    // Ajout du bouton dans le panneau correspondant
		    (i < 8 ? lowBytePanel : higBytePanel).add(checkBoxList[i]);
		}
		// Mise � jour de la vue
		update();
	    }
	    public void actionPerformed(ActionEvent event) {
		// Calcul de la valeur
		// Parcours des boutons en partant des poids forts
		int value = 0;
		for(int i = checkBoxNbr-1; i >= 0; i--) {
		    value <<= 1;
		    if (checkBoxList[i].isSelected())
			value++;
		}
		// Envoi de la valeur au contr�leur
		controller.notify(value);
	    }
	    // Mise � jour de la vue
	    void update() {
		// Valeur � visualiser
		int value = model.getValue();
		// Parcours des boutons en partant des poids faibles
		for(int i = 0; i < checkBoxNbr; i++) {
		    // Bouton activ� si le bit i vaut 1
		    checkBoxList[i].setSelected((value%2) == 1);
		    // D�calage des bits
		    value >>= 1;
		}
	    }
	}
    }

    /** Contr�leur */
    class Controller {
	void notify(int value) {
	    // Mise en place de la nouvelle valeur
	    model.setValue(value);
	    // Force la vue � se mettre � jour
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
    int getValue() { return value; }
}


