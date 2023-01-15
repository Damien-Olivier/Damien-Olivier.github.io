 /*
    Un JTextField et un JTextArea sont mis dans une
    fenêtre et un ActionListener est jouté au champ
    de saisie du texte JTextField. A chaque fois que du 
    texte est saisi, il est ajouté à la zone texte JTextArea.
*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// On dérive pour créer une fenêtre
public class SimpleEvents extends JFrame {

  static final int WIDTH=450;
  static final int HEIGHT=180;

  // Zone de texte pour les entrées utilisateur
  JTextField textField;

  //La  trace 
  JTextArea textList;
  
 // Volet qui accueille le JTextArea
  // Avec ascenseur
  JScrollPane pane;
  
  public SimpleEvents(String lab) {
    super(lab);
  
/******* Conteneur pour JTextField ****/

    // On crée un panneau
    JPanel textPanel = new JPanel();

    // On définit un entourage au panneau
    // Par défaut il n'en exite pas
    textPanel.setBorder (
      BorderFactory.createEtchedBorder());
  
    // Définition du gestionnaire de placement
    textPanel.setLayout(new BorderLayout());

    // Le texte et on l'ajoute
    JLabel textTitle = 
      new JLabel("Entrez votre texte puis <ENTER>");
    textPanel.add(textTitle, BorderLayout.NORTH);

 
    // On crée le JTextField on l'ajoute au textPanel (panneau)
    textField = new JTextField();
    textPanel.add(textField, BorderLayout.SOUTH);

/******* Conteneur pour le JtextArea ********/

    // On crée un panneau
    JPanel listPanel = new JPanel();

    // Encadrement
   listPanel.setBorder (
      BorderFactory.createEtchedBorder());

    // Définition du gestionnaire de placement
    listPanel.setLayout(
      new BoxLayout(listPanel,BoxLayout.Y_AXIS));

    // Nom du panneau
    JLabel title = new JLabel("Trace");
    listPanel.add(title);

    // On crée le  JTextArea sans texte
    // 6 ligne 10 colonnes
    textList=new JTextArea("", 6, 10);

    // Lecture seulement
    textList.setEditable(false);

    // On ajoute le textList au listPanel
    pane = new JScrollPane (textList);
    listPanel.add(pane);

/***** Gestionnaire d'événements ajouté au textField ***********/
   /* Le gestionnaire doit répondre aux entrées de l'utilisateur */
 
    textField.addActionListener(new ActionListener() {           
      public void actionPerformed(ActionEvent e) {
        // On ajoute le texte du textField à textList
        textList.append(textField.getText());
        textList.append("\n");
        // Mise à blanc du  textField
        textField.setText("");
      }
    });

    // On ajoute deux panneaux à la fenêtre, separated by a strut
    Container c = getContentPane();
    c.setLayout (new FlowLayout());
    c.add(textPanel);
    // Marge
    c.add(Box.createHorizontalStrut(30));
    c.add(listPanel);
 }  

  public static void main(String args[]) {
    SimpleEvents frame = 
      new SimpleEvents("Exemple");

  
    frame.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });

    frame.setSize(WIDTH, HEIGHT);
    frame.setVisible(true);
 }
}
