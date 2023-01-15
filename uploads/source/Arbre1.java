import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.tree.*;
import javax.swing.event.*;


class Arbre extends JPanel
{
    JTree tree;
    JLabel message;
    JButton voir;
    public Arbre() {
       //     

      DefaultMutableTreeNode top, noeud, fils, n;

      top = new DefaultMutableTreeNode("Top");
      
      noeud = new DefaultMutableTreeNode("Repertoire 1");
      top.add(noeud);
      
      n = new DefaultMutableTreeNode("1a");
      noeud.add(n);
      n = new DefaultMutableTreeNode("1b");
      noeud.add(n);
      n = new DefaultMutableTreeNode("1c");
      noeud.add(n);
      n = new DefaultMutableTreeNode("1d");
      noeud.add(n);

      noeud = new DefaultMutableTreeNode("Repertoire 2");
      top.add(noeud);

      n = new DefaultMutableTreeNode("2a");
      noeud.add(n);
      n = new DefaultMutableTreeNode("2b");
      noeud.add(n);
      n = new DefaultMutableTreeNode("2c");
      noeud.add(n);
      fils = new DefaultMutableTreeNode("2d");
      noeud.add(fils);
      
      n = new DefaultMutableTreeNode("3a");
      fils.add(n);

      tree = new JTree(top);
      DefaultTreeCellRenderer rendu ;
      rendu = (DefaultTreeCellRenderer) tree.getCellRenderer();
      rendu.setOpenIcon(new ImageIcon("Opened.gif"));
      rendu.setLeafIcon(new ImageIcon("Leaf.gif"));
      tree.addTreeSelectionListener(new Selecteur());

      JScrollPane scrollpane = new JScrollPane(tree);
      setLayout( new BorderLayout() );
      add( scrollpane , BorderLayout.CENTER);
      message = new JLabel(" ");
      add(message, BorderLayout.SOUTH);
      voir = new JButton("Voir");
voir.addActionListener(new Parcours());
JPanel haut = new JPanel();
haut.add(voir);
      add(haut, BorderLayout.NORTH);
   }


class Selecteur implements TreeSelectionListener {
   public void valueChanged( TreeSelectionEvent e ) {
       message.setText( "Chemin :  " + e.getNewLeadSelectionPath() );
   }
}

class Parcours implements ActionListener {
  public void actionPerformed(ActionEvent ev) {
    DefaultMutableTreeNode n,top;
    Enumeration e;
    top = (DefaultMutableTreeNode)tree.getModel().getRoot();
    System.out.println("\nbreadthFirst: En largeur");
    e = (top).breadthFirstEnumeration();
    while (e.hasMoreElements()) {
      n = (DefaultMutableTreeNode) e.nextElement();
      System.out.println(n.getUserObject()+" ");
    }
    System.out.println("\ndepthFirst: En profondeur post");
    e = (top).depthFirstEnumeration();
    while (e.hasMoreElements()) {
      n = (DefaultMutableTreeNode) e.nextElement();
      System.out.println(n.getUserObject()+" ");
    }
    System.out.println("\npostorder: En post profondeur");
    e = (top).postorderEnumeration();
    while (e.hasMoreElements()) {
      n = (DefaultMutableTreeNode) e.nextElement();
      System.out.println(n.getUserObject()+" ");
    }
    System.out.println("\npreorder: En prefixe profondeur");
    e = (top).preorderEnumeration();
    while (e.hasMoreElements()) {
      n = (DefaultMutableTreeNode) e.nextElement();
      System.out.println(n.getUserObject()+" ");
    }



  }
}

}


public class Arbre1 {
    static public void main(String[] args) {
       JFrame f = new JFrame("Arbres");
       JPanel p = new Arbre();
       f.setContentPane(p);
       f.setSize(300,300);
       f.setVisible(true);
       f.addWindowListener(new Fermeur());
    }
}

