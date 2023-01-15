import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JSplitPaneEx extends JFrame {
    private JButton jButton1;
    private JButton jButton2;
    private JPanel jPanel1;
    private JToolBar jToolBar1;
    private JSplitPane panelBas;
    private JSplitPane panelHorizontal;

    public JSplitPaneEx() {
        initComponents();
    }
   
    private void initComponents() {
        jPanel1 = new JPanel();
        panelBas = new JSplitPane();
        panelHorizontal = new JSplitPane(JSplitPane.VERTICAL_SPLIT,new JLabel("haut"), new JLabel("bas"));
        jToolBar1 = new JToolBar();
        jButton1 = new JButton();
        jButton2 = new JButton();

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent evt) {
                System.exit(0);
            }
        });

        jPanel1.setLayout(new BorderLayout());

        panelBas.setLeftComponent(panelHorizontal);
	panelBas.setRightComponent(new JLabel("Droit"));	

        jPanel1.add(panelBas, BorderLayout.CENTER);

        getContentPane().add(jPanel1, BorderLayout.CENTER);

        jButton1.setText("agrandir");
        jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                actionAgrandir(evt);
            }
        });

        jToolBar1.add(jButton1);

        jButton2.setText("reduire");
        jButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                actionReduire(evt);
            }
        });

        jToolBar1.add(jButton2);

        getContentPane().add(jToolBar1,BorderLayout. NORTH);

    }

    private void actionReduire(ActionEvent evt) {
        panelHorizontal.setDividerLocation(0.8d);
        panelBas.setDividerLocation(0.2d);
    }

    private void actionAgrandir(ActionEvent evt) {
        panelHorizontal.setDividerLocation(0d);
        panelBas.setDividerLocation(1d);
    }

    public static void main(String args[]) {
        JSplitPaneEx js = new JSplitPaneEx();
	js.pack();
	js.setVisible(true);
    }
}
