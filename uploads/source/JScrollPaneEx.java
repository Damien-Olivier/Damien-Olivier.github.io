import java.awt.Dimension; 
import javax.swing.*; 

public class JScrollPaneEx { 
    public static void main(String argv[]) { 
	JFrame f = new JFrame("ma fenetre"); 
	f.setSize(300, 100); 
	JPanel pannel = new JPanel(); 
	JTextArea textArea1 = new JTextArea ("mon texte"); 
	JScrollPane scrollPane = new JScrollPane(textArea1); 
	scrollPane.setPreferredSize(new Dimension(200,70)); 
	pannel.add(scrollPane); 
	f.getContentPane().add(pannel); 
	f.setVisible(true); 
    }
}
