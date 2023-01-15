import java.awt.*; 
public class MaFrame extends Frame {
  public MaFrame() { 
    super(); 
    setTitle(" Titre de la Fenetre "); 
    setSize(300, 150); 
    setVisible(true); // affiche la fenetre 
  } 
  public static void main(String[] args) { 
    new MaFrame(); } 
}
