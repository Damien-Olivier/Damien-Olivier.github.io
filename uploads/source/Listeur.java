import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Listeur extends JFrame implements ActionListener, MouseListener, KeyListener {
   
   JTextField tf1;
   JButton bLister;
   
   File[] vListe;
   JList list1;

   public static void main(String[] args) {
      new Listeur();
   }
   
   public Listeur(){
      this.setTitle("Lister un répertoire");
      this.setLocation(400,300);
      
      JPanel pan1 = new JPanel();
      pan1.setLayout(new BorderLayout(10,10));
      
         tf1 = new JTextField("Tape ici le chemin à atteindre");
      pan1.add(tf1,BorderLayout.WEST);
      
         bLister = new JButton("Lister");
         bLister.addActionListener(this);
      pan1.add(bLister,BorderLayout.CENTER);
      
         // code de listage dans un JScrollPane
         JScrollPane scroll1 = new JScrollPane();
            File rep = new File("D:/Anonym/docs/img/");
            vListe = rep.listFiles();
            list1 = new JList(vListe);
            list1.setBounds(5,10,500,700);
            list1.addMouseListener(this);
         scroll1.getViewport().add(list1);

      pan1.add(scroll1,BorderLayout.SOUTH);
      this.getContentPane().add(pan1);
      
      this.pack();
      this.show();
   }
   
   public void Lister_click(){
      File rep = new File(tf1.getText());
      System.out.println(tf1.getText());
   }

   public void actionPerformed(ActionEvent a) {
      if(a.getSource()==bLister){
         Lister_click();
      }
   }

   public void mouseClicked(MouseEvent a) {
      int index;
      if(a.getSource()==list1){
         index = list1.locationToIndex(a.getPoint()); //récupération de la position du click
         if(a.getClickCount()==1){
            System.out.println("numéro d'index : "+list1.getSelectedIndex()); //affichage des caractéristiques
         }else{
            tf1.setText(list1.toString());
            Lister_click();
         }
      }
   }
}
