import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

class SimpleTable2 extends JComponent {
    
    SimpleTable2() {
	Object[][] data = {
	    {"Voltaire", "Candide", "oui" },
	    {"Hugo", "Les misérables", "épuisé" },
	    {"Pérec", "La vie mode d'emploi", "oui" },
	    {"Berstel", "Cours Java", "oui"}};
	String[] columnNames = {"Auteur", "Livre", "Disponible" };
	JTable table = new JTable(data, columnNames);
	setLayout(new BorderLayout());
	add(new JScrollPane(table), BorderLayout.CENTER);
    }
    
    public static void main(String[] args) {
	JFrame f = new JFrame("Table simple");
	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	f.setContentPane(new SimpleTable2());
	f.setSize(480,90);
	f.setVisible(true);
    }
}
