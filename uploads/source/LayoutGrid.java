import java.awt.*; 

public class LayoutGrid extends Frame { 
 public LayoutGrid() { 
  super(); 
  setTitle(" Titre de la Fenetre "); 
  setSize(300, 150); 
  setLayout(new GridLayout(2,0)); 
  add(new Button("bouton 1")); 
  add(new Button("bouton 2")); 
  add(new Button("bouton 3")); add(new Button("bouton 4")); 
  add(new Button("bouton 5 tres long"));
  add(new Button("bouton 6")); 
  add(new Button("bouton 7")); 
  add(new Button("bouton 8")); 
  add(new Button("bouton 9")); 
  pack(); setVisible(true);
 } 

 public static void main(String[] args) { 
  new LayoutGrid(); 
 } 
}
