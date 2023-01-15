import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class InternalFrameDemoSimple extends JFrame {
    JDesktopPane desktop;

    public InternalFrameDemoSimple() {
        super("InternalFrame Demo");
        desktop = new JDesktopPane();
        createFrame();
        setContentPane(desktop);
	setSize(150,150);
	setVisible(true);
    }
    protected void createFrame() {
	JInternalFrame frame = new JInternalFrame("Fenêtre Interne",
						  true, //resizable
						  true, //closable
						  true, //maximizable
						  true);//iconifiable
	frame.setSize(100,100);
	frame.setVisible(true);
        desktop.add(frame);
        try {
            frame.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {}
	//desktop.revalidate();
    }
    
    public static void main(String[] args) {
	InternalFrameDemoSimple ifs = new InternalFrameDemoSimple();
	ifs.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
               System.exit(0);
            }
	    });
    }
}	
