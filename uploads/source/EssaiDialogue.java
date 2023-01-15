import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

public class EssaiDialogue extends JFrame implements ActionListener
{
  JLabel label = new JLabel("Essayer les differents boutons");
  MonDialogue monDialogue;

  public EssaiDialogue()
    {
      JPanel lesBoutons = new JPanel();
      Container interieur = getContentPane();

      lesBoutons.setLayout(new GridLayout(6, 2));    
      lesBoutons.add(new Label("un simple avertissement")); 
      ajoute("dialogue1", lesBoutons);   
      lesBoutons.add(new Label("question avec boutons conventionnels")); 
      ajoute("dialogue2", lesBoutons);  
      lesBoutons.add(new Label("question avec boutons personnalisés"));   
      ajoute("dialogue3", lesBoutons);
      lesBoutons.add(new Label("une facon de faire une saisie"));   
      ajoute("dialogue4", lesBoutons);
      lesBoutons.add(new Label("dialogue personnalisé non modal"));   
      ajoute("dialogue5", lesBoutons);
      lesBoutons.add(new Label("pour fermeture du dialogue ci-dessus"));
      ajoute("fermeture5", lesBoutons);  
      interieur.setLayout(new BorderLayout(5, 5));
      interieur.add(lesBoutons, BorderLayout.CENTER);
      interieur.add(label, BorderLayout.SOUTH);
    }

  void ajoute(String s, JPanel lesBoutons)
    {
      Button bouton = new Button(s);;

      bouton.setActionCommand(s);
      bouton.addActionListener(this);
      lesBoutons.add(bouton);
    }

  public void actionPerformed(ActionEvent e)
    {
      String nom = e.getActionCommand();

      if (nom.equals("dialogue1"))
	JOptionPane.showMessageDialog(this, "Ce n'est qu'un simple message",
				      "avertissement", 
				      JOptionPane.WARNING_MESSAGE);
      else if (nom.equals("dialogue2"))
	{
	  int reponse = JOptionPane.showConfirmDialog(this, 
			       "Etes-vous de bonne humeur ?", 
			       "Etiquettes Java", 
			        JOptionPane.YES_NO_OPTION);
	  if (reponse == JOptionPane.YES_OPTION) label.setText("Bravo!");
	  else if (reponse == JOptionPane.NO_OPTION) label.setText("Courage!");
          else  label.setText("ni l'un ni l'autre ?");
	}
      else if (nom.equals("dialogue3"))
	{
	  String[] choix = {"oui", "non", "pas d'opinion"};
	  int reponse = JOptionPane.showOptionDialog(this, 
			       "Etes-vous de bonne humeur ?", 
			       "Etiquettes du programmeur", 
			       JOptionPane.YES_NO_CANCEL_OPTION,
			       JOptionPane.QUESTION_MESSAGE,
			       null,
			       choix,
                               choix[2]);
	  if (reponse == JOptionPane.YES_OPTION) label.setText("Bravo!");
	  else if (reponse == JOptionPane.NO_OPTION) label.setText("Courage!");
          else  label.setText("Ni l'un ni l'autre ?");
	}
      
      else if (nom.equals("dialogue4")) 
	{
	  String reponse;
	  String message = "Quel est votre nom ?";
	  reponse = JOptionPane.showInputDialog(this, message);
	  label.setText(reponse);
	}
      else if (nom.equals("dialogue5")) 
	{
	  if ((monDialogue != null) && (monDialogue.isVisible())) return;
	  monDialogue = new MonDialogue(this);
	  monDialogue.setLocationRelativeTo(this);
          monDialogue.setVisible(true);
	}
      else if ((nom.equals("fermeture5")) && (monDialogue != null)) 
	{
	  monDialogue.dispose();
	}
    }

  public static void main(String[] argv)
  {
      JFrame monCadre = new EssaiDialogue();
      monCadre.addWindowListener(new WindowAdapter()
					{
					 public void windowClosing(WindowEvent e)
					 { System.exit(0);}
					}
				);
      monCadre.pack();
      monCadre.setVisible(true);
  }
}

class MonDialogue extends JDialog 
{
  MonDialogue(EssaiDialogue leCadre) 
    {
      super(leCadre, "Fenetre non modale", false);

      final JOptionPane panneauDialogue; // Utilisé par une classe interne => final
      final JTextField texte = new JTextField(20);
      final EssaiDialogue cadre = leCadre;
      Object[] lesObjets = {"Indiquez un texte", "puis faites un choix",
			    "regardez le message de la fenetre principale",
			    texte};
      String[] choix = {"petit", "grand", "aucun"};
      panneauDialogue = new JOptionPane(lesObjets, 
                                    JOptionPane.INFORMATION_MESSAGE,
                                    JOptionPane.OK_CANCEL_OPTION,
				     null, choix);
      setContentPane(panneauDialogue);
      pack();
      panneauDialogue.addPropertyChangeListener(
			      new PropertyChangeListener() 
		{
		  public void propertyChange(PropertyChangeEvent e) 
		    {
		      cadre.label.setText(panneauDialogue.getValue() 
					  + " " + texte.getText());
		    }
		});
      addWindowListener(new WindowAdapter()
	        {
		  public void windowClosing(WindowEvent e)
		    {
		      cadre.label.setText("fermeture");
		    }
		});
    }
}

     
