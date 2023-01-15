import java.awt.*; 

public class LayoutCard extends Frame { 
 public LayoutCard() { 
  super(); 
  setTitle("Titre de la Fenetre "); 
  setSize(300,150); 
  CardLayout cl = new CardLayout(); 
  setLayout(cl);
  //création d'un panneau contenant les contrôles d'un onglet
  Panel p = new Panel(); 
  //ajouter les composants au panel 
  p.add(new Button("Bouton 1 panneau 1")); 
  p.add(new Button("Bouton 2 panneau 1")); 
  //inclure le panneau dans la fenêtre sous le nom "Page1" 
  // ce nom est utilisé par show() 
  add("Page1",p); 
  //déclaration et insertion de l'onglet suivant 
  Panel p2 = new Panel(); p2.add(new Button("Bouton 1 panneau 2")); 
  add("Page2", p2); 
  // affiche la fenetre 
  p2.setVisible(true);
  p.setVisible(false);
  pack(); setVisible(true); 
 } 
 
 public static void main(String[] args) { 
  new LayoutCard(); 
 }
}
