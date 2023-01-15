import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.tree.*;
import javax.swing.event.*;


class Arbre extends JPanel
{
    private JTree arbre;
    private JLabel message;
    private JButton voir;
    private JTextArea jt;
    
    public Arbre() {
	DefaultMutableTreeNode racine, noeud, fils, n;

	racine = new DefaultMutableTreeNode("Racine");
      
	noeud = new DefaultMutableTreeNode("Repertoire 1");
	racine.add(noeud);
      
	n = new DefaultMutableTreeNode("1.1");
	noeud.add(n);
	n = new DefaultMutableTreeNode("1.2");
	noeud.add(n);
	n = new DefaultMutableTreeNode("1.3");
	noeud.add(n);
	n = new DefaultMutableTreeNode("1.4");
	noeud.add(n);
	
	noeud = new DefaultMutableTreeNode("Repertoire 2");
	racine.add(noeud);
	
	n = new DefaultMutableTreeNode("2.1");
	noeud.add(n);
	n = new DefaultMutableTreeNode("2.2");
	noeud.add(n);
	n = new DefaultMutableTreeNode("2.3");
	noeud.add(n);
	fils = new DefaultMutableTreeNode("2.4");
	noeud.add(fils);
	
	n = new DefaultMutableTreeNode("2.4.1");
	fils.add(n);
	
	arbre = new JTree(racine);
	DefaultTreeCellRenderer rendu ;
	rendu = (DefaultTreeCellRenderer)arbre.getCellRenderer();
	rendu.setOpenIcon(new ImageIcon("Ouvert.gif"));
	rendu.setLeafIcon(new ImageIcon("Feuille.gif"));
	arbre.addTreeSelectionListener(new Selecteur());
	
	JScrollPane scrollpane = new JScrollPane(arbre);
	setLayout( new BorderLayout() );
	add( scrollpane , BorderLayout.CENTER);
	message = new JLabel(" ");
	add(message, BorderLayout.SOUTH);
	voir = new JButton("Voir");
	voir.addActionListener(new Parcours());
	JPanel haut = new JPanel();
	haut.add(voir);
	add(haut, BorderLayout.NORTH);
	jt = new JTextArea(0,20);
	scrollpane =  new JScrollPane(jt);
	add(scrollpane, BorderLayout.EAST);
    }


class Selecteur implements TreeSelectionListener {
   public void valueChanged( TreeSelectionEvent e ) {
       message.setText( "Chemin :  " + e.getNewLeadSelectionPath() );
   }
}

class Parcours implements ActionListener {
  public void actionPerformed(ActionEvent ev) {
    DefaultMutableTreeNode n,racine;
    Enumeration e;
    racine = (DefaultMutableTreeNode)arbre.getModel().getRoot();
    jt.append("\nbreadthFirst: En largeur\n");
    e = (racine).breadthFirstEnumeration();
    while (e.hasMoreElements()) {
      n = (DefaultMutableTreeNode) e.nextElement();
      jt.append(n.getUserObject()+" \n");
    }
    jt.append("\ndepthFirst: En profondeur post\n");
    e = (racine).depthFirstEnumeration();
    while (e.hasMoreElements()) {
      n = (DefaultMutableTreeNode) e.nextElement();
      jt.append(n.getUserObject()+" \n");
    }
    jt.append("\npostorder: En post profondeur\n");
    e = (racine).postorderEnumeration();
    while (e.hasMoreElements()) {
      n = (DefaultMutableTreeNode) e.nextElement();
      jt.append(n.getUserObject()+" \n");
    }
    jt.append("\npreorder: En préfixe profondeur\n");
    e = (racine).preorderEnumeration();
    while (e.hasMoreElements()) {
      n = (DefaultMutableTreeNode) e.nextElement();
      jt.append(n.getUserObject()+" \n");
    }



  }
}

}

class Fermeur extends WindowAdapter {
    public void windowClosing(WindowEvent e){
	System.exit(0);
    }
}


public class ArbreDemo {
    static public void main(String[] args) {
       JFrame f = new JFrame("Arbres");
       JPanel p = new Arbre();
       f.setContentPane(p);
       f.pack();
       f.setVisible(true);
       f.addWindowListener(new Fermeur());
    }
}

