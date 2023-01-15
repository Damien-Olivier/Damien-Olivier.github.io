import java.awt.*;
import java.awt.event.*;
import java.awt.datatransfer.*;
import javax.swing.*;

public class ClipboardFrame extends JFrame {
    JTextArea txtArea = new JTextArea();
    JButton btnFrom = new JButton("Copy from System Clipboard");
    JButton btnTo = new JButton("Copy to System Clipboard");

    public ClipboardFrame() {
        this.setTitle("Test Clipboard");
        this.setSize(new Dimension(406, 280));
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent event) {
                System.exit(0);
            }
        });

        txtArea.setBounds(new Rectangle(9, 9, 381, 197));

        btnFrom.setBounds(new Rectangle(192, 214, 199, 23));
        btnFrom.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                btnFrom_actionPerformed(event);
            }
        });

        btnTo.setBounds(new Rectangle(9, 214, 179, 23));
        btnTo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                btnTo_actionPerformed(event);
            }
        });

        JPanel contentPane = (JPanel) this.getContentPane();
        contentPane.setLayout(null);
        contentPane.add(this.txtArea);
        contentPane.add(this.btnFrom);
        contentPane.add(this.btnTo);
    }

    void btnTo_actionPerformed(ActionEvent event) {
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        StringSelection data = new StringSelection(this.txtArea.getText());
        clipboard.setContents (data, data);
    }

    void btnFrom_actionPerformed(ActionEvent event) {
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        Transferable clipData = clipboard.getContents(clipboard);
        if (clipData != null) {
            try {
                String content = (String)(clipData.getTransferData(DataFlavor.stringFlavor));
                this.txtArea.setText(content);
            } catch (Exception exc) {
                exc.printStackTrace();
            }
        }
    }
    
    static public void main(String[] args) {
        (new ClipboardFrame()).setVisible(true);
    }
}
