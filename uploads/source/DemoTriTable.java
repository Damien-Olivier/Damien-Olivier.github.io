/**
 * @version 1.00 1999-07-17
 * @author d'après Cay Horstmann
 */

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;

public class DemoTriTable {
    /**
       La fenêtre principale et le tableau des planêtes
    */
    public static void main(String[] args) {
	JFrame f = new JFrame();
	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	f.setContentPane(new TablePlanetes());
	f.setSize(300, 100);
	f.setVisible(true);
    }
}

/**
   Définit la gestion des données
*/
class FiltreTriModel extends AbstractTableModel 
{
    /** Modéle de gestion des données */
    private TableModel modele;
    /** Colonne sur laquelle s'effectue le tri */
    private int colonneTri;
    private Ligne[] lignes;

    public FiltreTriModel(TableModel m) {
	modele = m;
	lignes = new Ligne[modele.getRowCount()];
	for (int i = 0; i < lignes.length; i++) {
	    lignes[i] = new Ligne();
	    lignes[i].index = i;
	}
    }
    
    public void sort(int c) {
	colonneTri = c;
	Arrays.sort(lignes);    // Tri des lignes
	fireTableDataChanged(); // Informe les écouteurs que le contenu
	                        // des cellules a changé
    }
    
    public void addEcouteur(final JTable table) {
	table.getTableHeader().addMouseListener(new MouseAdapter() {
		public void mouseClicked(MouseEvent event) {
		    if (event.getClickCount() < 2) return;
		    int tableColumn = table.columnAtPoint(event.getPoint());
		    int modelColumn
			= table.convertColumnIndexToModel(tableColumn);
		    sort(modelColumn);
		}
	    });
    }
    
    public Object getValueAt(int r, int c) {
	return modele.getValueAt(lignes[r].index, c);
    }

    /* AbstractTableModel est une classe abstraite, il faut 
       fournir le code des 3 méthodes suivantes */
    public int getRowCount(){  return modele.getRowCount();}
    public int getColumnCount(){  return modele.getColumnCount();}
    public String getColumnName(int c){  return modele.getColumnName(c);}
    
    private class Ligne implements Comparable
    {  public int index;
	public int compareTo(Object autre)	
	{  
	    Ligne autreLigne = (Ligne)autre;
	    Object a = modele.getValueAt(index, colonneTri);
	    Object b = modele.getValueAt(autreLigne.index, colonneTri);
	    if (a instanceof Comparable && b instanceof Comparable)	    
		return ((Comparable)a).compareTo(b);
	    else return index - autreLigne.index;
	}
    }
}


class TablePlanetes extends JPanel 
{
    private Object[][] cellules = {
	{ "Mercure", new Double(2440), new Integer(0), "non"},
	{ "Vénus", new Double(6052), new Integer(0), "non"},
	{ "Terre", new Double(6378), new Integer(1), "non"},
	{ "Mars", new Double(3397), new Integer(2), "non"},
	{ "Jupiter", new Double(71492), new Integer(16), "oui"},
	{ "Saturne", new Double(60268), new Integer(18), "oui"},
	{ "Uranus", new Double(25559), new Integer(17), "oui"},
	{ "Neptune", new Double(24766), new Integer(8), "oui"},
	{ "Pluton", new Double(1137), new Integer(1), "non"}
    };
    private String[] columnNames ={ "Planète", "Rayon", "Lunes", "Gazeuse"};
   
    TablePlanetes() {
	setLayout(new BorderLayout());
	// Modèle par défaut sur lequel on applique le filtre
	DefaultTableModel modele = new DefaultTableModel(cellules, columnNames);
	FiltreTriModel trier = new FiltreTriModel(modele);
	JTable table = new JTable(trier);
	trier.addEcouteur(table);
	add(new JScrollPane(table), BorderLayout.CENTER);
    }
}
