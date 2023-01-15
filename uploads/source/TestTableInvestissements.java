/**
 * @version 1.00 1999-07-17
 * @author Cay Horstmann
 */

import java.awt.*;
import java.awt.event.*;
import java.text.*;
import javax.swing.*;
import javax.swing.table.*;

public class TestTableInvestissements{

  public static void main(String[] args) {
    JFrame f = new JFrame();
		f.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        System.exit(0);
			}
		} );
		f.getContentPane().add(new TableInvestissements());
		f.setSize(300, 100);
    f.setVisible(true);
   }
}

class TableInvestissements extends JPanel {
	TableInvestissements() {
		setLayout(new BorderLayout());
    TableModel model = new ModelInvestment(30, 5, 10);
    JTable table = new JTable(model);
		add(new JScrollPane(table), BorderLayout.CENTER);
	}
}

class ModelInvestment extends AbstractTableModel {
  private int annees;
  private int tauxMin;
  private int tauxMax;
  private static double depot = 100000.0;

  ModelInvestment(int annees, int tauxMin, int tauxMax) {
    this.annees = annees;
		this.tauxMin = tauxMin;
		this.tauxMax = tauxMax;
	}

  public int getRowCount() {
    return annees;
	}

  public int getColumnCount() {
    return tauxMax - tauxMin + 1;
	}

  public Object getValueAt(int ligne, int colonne) {
		double taux = (colonne + tauxMin) / 100.0;
		double depotFinal = depot * Math.pow(1 + taux, ligne);
    return
      NumberFormat.getCurrencyInstance().format(depotFinal);
	}

  public String getColumnName(int colonne) {
    double taux = (colonne + tauxMin) / 100.0;
    return
      NumberFormat.getPercentInstance().format(taux);
	}
}

