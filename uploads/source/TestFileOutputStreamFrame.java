import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class TestFileOutputStreamFrame extends Frame { 
    TextField tf = new TextField("Nom du fichier"); 
    Label l1 = new Label("Nom Fichier ");
    Label l2 = new Label("Votre Texte :"); 
    Button ok = new Button("Sauve"); 
    TextArea txt = new TextArea(10, 10); 
    FileOutputStream fos; 
    String s ; 
    byte b[] ; 

    public static void main(String args[]){ 
	TestFileOutputStreamFrame tfos = new TestFileOutputStreamFrame(); 
	tfos.exec(); 
    } 
    
    void exec(){ 
	setLayout(new FlowLayout()); 
	add(l1); add(tf); add(l2); add (txt); add(ok); 
	ok.addActionListener(new ActionL()); 
	pack(); 
	setVisible(true); 
    } 
    
    void update_file(){ 
	String nomf = tf.getText(); 
       	File fic = new File(nomf); 
	System.out.println(nomf);
	s = txt.getText(); 
	try{ 
	    fos= new FileOutputStream(fic); 
	    int l; 
	    b= new byte[l=s.length()]; 
	    for (int i=0; i<l; i++) b[i]= (byte) s.charAt(i); 
	    fos.write(b); 
	    fos.close(); 
	} catch(IOException e2){System.out.println("Err I/O "+e2);} 
    }

    class ActionL implements ActionListener { 
	public void actionPerformed(ActionEvent e){ 
	    if (e.getSource() == ok) { 
		update_file();
		System.exit(0);
	    } 
	}
    }
}// Fin de la class TestFileOutputStream
