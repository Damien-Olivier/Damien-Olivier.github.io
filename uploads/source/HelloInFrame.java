import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class HelloPanel extends JPanel {
    public void paintComponent(Graphics g) {
	super.paintComponent(g);
	g.drawString("Bonjour", 75, 100);
    }
}

class Terminator extends WindowAdapter {
    public void windowClosing(WindowEvent e) {
	System.exit(0);
    }
}

class HelloFrame extends JFrame {
    public HelloFrame() {
	setTitle("HelloInFrame"); setSize(300, 200);
	addWindowListener(new Terminator());
/*	Container HelloContainer = getContentPane();
	HelloContainer.add(new HelloPanel());*/
	add(new HelloPanel());
    }
}

public class HelloInFrame {
    public static void main(String[] args) {
	JFrame frame = new HelloFrame();
	frame.setLocationRelativeTo(null);
	frame.setVisible(true);
    }
}
