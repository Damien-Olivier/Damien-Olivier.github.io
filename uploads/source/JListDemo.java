import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JListDemo extends JFrame {
    File fle;
    JFileChooser choix = new JFileChooser();
    JTextField repertoire=new JTextField(10);
    JList jl=new JList();

    public JListDemo() {
	Container c = getContentPane();
	JButton bouton = new JButton("Naviguer");
	JPanel p = new JPanel();
	p.add(bouton);
	bouton.addActionListener(new ActionListener()
	    {
		public void actionPerformed(ActionEvent e){
		    choix.setFileSelectionMode(choix.DIRECTORIES_ONLY);
		    int returnVal = choix.showOpenDialog(null);
		    if(returnVal == JFileChooser.APPROVE_OPTION){
			fle=choix.getSelectedFile();
			repertoire.setText(fle.getName());
		    }
		}
	    });
	p.add(repertoire);
	bouton = new JButton("Fichier(s)");
	p.add(bouton);
	bouton.addActionListener(new ActionListener()
	    {
		public void actionPerformed(ActionEvent e){
		    if(fle!=null)jl.setListData(fle.list());
		}
	    });
	c.add(p, BorderLayout.NORTH);
	JScrollPane jspFiles=new JScrollPane(jl);
	c.add(jspFiles);
	addWindowListener(new WindowAdapter()
	    {
		public void windowClosing(WindowEvent e){
		    setVisible(false);
		    System.exit(0);
		}
	    });
	setTitle("Navigation dans les répertoires");
	pack();
	setVisible(true);
    }

    public static void main(String[] args) {
	new JListDemo();
    }		
}
