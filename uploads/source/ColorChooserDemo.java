import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.colorchooser.*;

public class ColorChooserDemo extends JPanel
                              implements ChangeListener {

    protected JColorChooser tcc;
    protected JLabel banner;

    public ColorChooserDemo() {
        super(new BorderLayout());

        banner = new JLabel("Demonstration d'un JColorChooser",
                            JLabel.CENTER);
        JPanel bannerPanel = new JPanel(new BorderLayout());
        bannerPanel.add(banner, BorderLayout.CENTER);
        tcc = new JColorChooser(banner.getForeground());
        tcc.getSelectionModel().addChangeListener(this);
        add(bannerPanel, BorderLayout.CENTER);
        add(tcc, BorderLayout.PAGE_END);
    }

    public void stateChanged(ChangeEvent e){
        banner.setForeground(tcc.getColor());
    }

    public static void main(String[] args){
        JFrame frame = new JFrame("Demo de JColorChooser");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setContentPane(new ColorChooserDemo());

        frame.pack();
        frame.setVisible(true);
    }
}
