import java.awt.*; 

public class LayoutGridBag extends Frame { 
  public LayoutGridBag() { 
   super(); 
   setTitle(" Titre de la Fenetre "); 
   setSize(300, 150); 
   Button b1 = new Button(" bouton 1 "); 
   Button b2 = new Button(" bouton 2 "); 
   Button b3 = new Button(" bouton 3 "); 
   GridBagLayout gb = new GridBagLayout(); 
   GridBagConstraints gbc = new GridBagConstraints(); 
   setLayout(gb); 
   gbc.fill = GridBagConstraints.BOTH; 
   gbc.weightx = 1; 
   gbc.weighty = 1;
   //gbc.gridx = 1;
   gb.setConstraints(b1, gbc); 
   // mise en forme des objets 
   gb.setConstraints(b2, gbc); 
   gb.setConstraints(b3, gbc); 
   add(b1); add(b2); add(b3); 
   pack(); setVisible(true);
  } 
  public static void main(String[] args) { 
  new LayoutGridBag(); 
  } 
}
