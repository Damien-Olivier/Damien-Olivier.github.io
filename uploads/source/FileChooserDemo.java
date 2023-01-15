import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.filechooser.*;

/**
   Classe pour filtrer les fichiers
 */
class FileFilterTex extends javax.swing.filechooser.FileFilter {
    String filtre;
    String description;
    
    public FileFilterTex(String filtre, String description)
    {
	super();
	this.filtre = filtre;
	this.description = description;
    }
    
	

    public boolean accept(File f) {
	if (f.isDirectory())
            return true;
	else {
	    String extension = null;
	    String s = f.getName();
	    int i = s.lastIndexOf('.');
	    if (i > 0 &&  i < s.length() - 1) {
		extension = s.substring(i+1).toLowerCase();
	    }
	    return (extension != null) ? extension.equals(filtre) : false;
	}
    }
    
  public String getDescription() {
        return description;
    }
	
}


public class FileChooserDemo extends JPanel
                             implements ActionListener {
    JButton openButton, saveButton;
    JTextArea log;
    JFileChooser fc;

    public FileChooserDemo() {
        super(new BorderLayout());

        log = new JTextArea(5,20);
	log.setMargin(new Insets(5,5,5,5));
        log.setEditable(false);
        JScrollPane logScrollPane = new JScrollPane(log);

        //Creation de la fenêtre de dialogue pour les fichiers
        fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES); // Fichiers et rep
	fc.addChoosableFileFilter(new FileFilterTex("tex","Fichiers Latex"));

	// Les boutons
        openButton = new JButton("Ouvrir un fichier ...");
        openButton.addActionListener(this);
        saveButton = new JButton("Sauver un fichier...");
        saveButton.addActionListener(this);
	
	// On crée un paneau pour les boutons et on les ajoute
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(openButton);
        buttonPanel.add(saveButton);

	// On ajoute nos boutons et le paneau permettant de visualiser
	// les actions et le contenu des fichiers
        add(buttonPanel, BorderLayout.NORTH);
        add(logScrollPane, BorderLayout.CENTER);
    }

    private void displayFile(String filename)
    {
        FileReader f=null;
        int i;        
	try
            {
                f = new FileReader(filename);
		StringBuffer buf = new StringBuffer();
                while ((i = f.read()) != -1)
		    buf.append((char )i);
		log.append(new String(buf));
                f.close();
            }
        catch (FileNotFoundException fnfe) {
            System.err.println(fnfe);
        }
        catch (IOException ioe) {
            System.err.println(ioe);
        }
    }


    public void actionPerformed(ActionEvent e) {

        // Ouvrir
        if (e.getSource() == openButton) 
	    {
		int returnVal = fc.showOpenDialog(FileChooserDemo.this);
		
		if (returnVal == JFileChooser.APPROVE_OPTION) 
		    {
			File file = fc.getSelectedFile();
			log.append("Ouverture: " + file.getName() + ".\n");
			displayFile(file.getParent()+"/"+file.getName());	
		    } 
		else log.append("Annulé\n");
	    } 
	// Sauvegarde
	else if (e.getSource() == saveButton) 
	    {
		int returnVal = fc.showSaveDialog(FileChooserDemo.this);
		if (returnVal == JFileChooser.APPROVE_OPTION) 
		    {
			File file = fc.getSelectedFile();
			log.append("Sauvegarde: " + file.getName() + ".\n" + "non implémenté\n");
		    } 
		else log.append("Annulé\n");
	    }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("FileChooserDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JComponent newContentPane = new FileChooserDemo();
        newContentPane.setOpaque(true);
        frame.setContentPane(newContentPane);

        frame.pack();
        frame.setVisible(true);
    }
}


