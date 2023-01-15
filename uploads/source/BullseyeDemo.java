// BullseyeDemo.java - Uses JSlider, graphics JPanel, BoxLayout.
// @version 1998-07-27 ... 2002-02-07
// @author Fred Swartz

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/////////////////////////////////////////////////////// class BullseyeDemo
public class BullseyeDemo {
    //=============================================================== main
    public static void main(String[] args) {
        JFrame target = new BullseyeWindow();
        target.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        target.setVisible(true);
    }//end main
}//endclass BullseyeDemo


//////////////////////////////////////////////////////// class BullseyeWindow
class BullseyeWindow extends JFrame {
    int initialRings = 10; // Number of rings to start with.
    Bullseye be;           // The panel that draws the bullseye

    //=========================================================== constructor
    public BullseyeWindow() {
        JSlider slide = new JSlider(JSlider.HORIZONTAL, 0, 30, initialRings);
        slide.setMajorTickSpacing(5); // sets numbers for biggest tick marks
        slide.setPaintLabels(true);   // display numbers on major ticks
        slide.setMinorTickSpacing(1); // smaller tick marks
        slide.setPaintTicks(true);    // display the ticks
        slide.addChangeListener(new ChangeListener() {
                public void stateChanged(ChangeEvent e) {
                    int num = ((JSlider)(e.getSource())).getValue();
                    be.setRings(num);
                }
            });

        be = new Bullseye();
        be.setRings(initialRings);

        Container content = this.getContentPane();
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
        content.add(slide);
        content.add(be);
        
        this.setTitle("BullseyeDemo");
        this.pack();
        this.setResizable(false);
    }//end constructor
}//endclass BullseyeWindow


//////////////////////////////////////////////////////////// class Bullseye
class Bullseye extends JPanel {
    static final int SIZE = 300; // initial window size
    int rings = 5;  // Number of rings to draw in bullseye

    //========================================================= constructor
    public Bullseye() {
        this.setBackground(Color.white);
        this.setPreferredSize(new Dimension(SIZE, SIZE));
    }//end constructor

    //=========================================================== setRings
    public void setRings(int r) {
        rings = r;
        this.repaint();  // new value of rings - better repaint
    }//end setRings

    //===================================================== paintComponent
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int x = SIZE/2;  // x,y of top left corner for drawing circles
        int y = SIZE/2;
        
        for (int i=rings; i>0; i--) {
            if (i%2 == 0) {
                g.setColor(Color.red);
            } else {
                g.setColor(Color.blue);
            }
            int radius = i * 100/rings;  // compute radius of this ring
            g.fillOval(x-radius, y-radius, radius*2, radius*2);
        }
    }//end paintComponent
}//endclass Bullseye
