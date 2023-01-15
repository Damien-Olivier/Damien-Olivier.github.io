import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class ScrollPanel extends JPanel {
   public ScrollPanel() {
      setLayout(new BorderLayout());
      Icon iconeTigre = new ImageIcon("BigTiger.gif");
      JLabel etiquetteTigre = new JLabel(iconeTigre);
      JScrollPane scrollPane = new JScrollPane(etiquetteTigre);
      add(scrollPane, BorderLayout.CENTER);
   }
}
public class TestTigre {
   public static void main (String[] argv) {
      JFrame r = new JFrame("Un grand tigre");
      r.setContentPane(new ScrollPanel());
      r.setSize(600,600);
      r.setVisible(true);
      r.addWindowListener(new WindowCloser());
   }
}
class WindowCloser extends WindowAdapter {
    public void windowClosing(WindowEvent e) {
       System.exit(0);
    }
}
