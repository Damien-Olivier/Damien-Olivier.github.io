import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PanelDemo {
    public static void main(String s[]) {
        JFrame frame = new JFrame("FrameDemo");
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
               System.exit(0);
            }
        });

        // Le texte est dans le label
        JLabel label = new JLabel("Un texte dans un label");
        // le label dans un panel
        JPanel aPanel = new JPanel();
	// QQ modif d'apparence ...
	aPanel.setBackground(new Color(0, 255, 255));
	aPanel.setBorder(BorderFactory.createCompoundBorder(
                        BorderFactory.createTitledBorder("Quel beau Titre"),
                        BorderFactory.createEmptyBorder(5,5,5,5)));
        aPanel.add(label);

        // et on place le panel dans la frame
/*        Container contentPane = frame.getContentPane();
        contentPane.add(aPanel);*/
	frame.add(aPanel);
        frame.pack();
        frame.setVisible(true);
    }
}
