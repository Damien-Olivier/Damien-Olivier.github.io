import java.awt.*; 
import java.awt.event.* ;

class FenetreCompteur extends Frame {
  int compteur ;
  // définition des boutons avec texte
  Button boutonIncr = new Button("+");
  Button boutonDecr = new Button("-");
  Button boutonQuit = new Button("quit");

  // un champ valeur du compteur (7 :taille des car.)
  TextField affichageCompteur = new TextField(7);

  //gestion des évènements : clics sur les boutons
  class ActionIncr implements Action Listener{ 
    public synchronized void actionPerformed(ActionEvent e)
    {  compteur ++; afficherCompteur(); }
  };

  class ActionDecr implements ActionListener{ 
    public synchronized void actionPerformed(ActionEvent e)
    {  compteur --; afficherCompteur(); }
  };

  class ActionQuit implements ActionListener{ 
    public synchronized void actionPerformed(ActionEvent e)
    {  System.exit(0); }
  };

  void afficherCompteur()
  {  affichageCompteur.setText(String.valueOf(compteur));}

  public FenetreCompteur(String nom)
  {
    super("compteur " + nom);
    compteur = 0;
    setSize(150, 100);
    setLayout(new FlowLayout());
    add(boutonIncr);
    add(boutonDecr);
    add(boutonQuit);
    add(affichageCompteur);
    boutonIncr.addActionListener(new ActionIncr());
    boutonDecr.addActionListener(new ActionDecr());
    boutonQuit.addActionListener(new ActionQuit());
  }
}

public class TestAWT
{ 
  static public void main(String argv[])
  {  
    FenetreCompteur x = new FenetreCompteur("CPT1");
    x.setVisible(true);
 }
}
