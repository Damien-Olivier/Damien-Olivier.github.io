import java.awt.*; 
public class LayoutBorder extends Frame { 
 public LayoutBorder() { 
  super(); 
  setTitle(" Titre de la Fenetre "); 
  setSize(300, 150); 
  setLayout(new BorderLayout()); 
  add("North",  new Button(" bouton Nord ")); 
  add("South",  new Button(" bouton Sud ")); 
  add("West",   new Button(" bouton Ouest ")); 
  add("East",   new Button(" bouton Est ")); 
  add("Center", new Button(" bouton Centre ")); 
  pack(); setVisible(true); // affiche la fenetre 
 } 
 public static void main(String[] args) { 
  new LayoutBorder(); 
 } 
}
