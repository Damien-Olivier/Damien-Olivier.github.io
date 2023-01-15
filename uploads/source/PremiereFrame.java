import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;



class FrameBonjour extends JFrame 
{
  class ThisIsTheENd extends WindowAdapter
  {
		public void windowClosing(WindowEvent e)
		{
			System.exit(0);
		}
   }
   class Message extends JPanel {
      public void paintComponent(Graphics g) {
         super.paintComponent(g);
         g.drawString("Hello", 100, 100);
      }
   }
   
	public FrameBonjour() {
		setTitle("Hello");
		setSize(400, 400);
		addWindowListener(new ThisIsTheENd());
		add(new Message());
	}
}



public class PremiereFrame {
	public static void main(String[] args) {
		FrameBonjour f = new FrameBonjour();
		f.setVisible(true);
	}
}

