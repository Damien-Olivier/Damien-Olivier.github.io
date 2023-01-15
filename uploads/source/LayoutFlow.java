import java.awt.*; 

public class LayoutFlow extends Frame { 
  public LayoutFlow() { 
   super(); setTitle(" Titre de la Fenetre "); 
   setSize(300, 150); setLayout(new FlowLayout()); 
   add(new Button("Bouton 1")); 
   add(new Button("Bouton 2")); 
   add(new Button("Bouton 3")); 
   pack(); setVisible(true); // affiche la fenetre 
  } 
  public static void main(String[] args) { 
  new LayoutFlow(); 
  } 
}
