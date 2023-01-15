import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PlafMenu extends JMenu implements ActionListener {
	UIManager.LookAndFeelInfo[] lfi = UIManager.getInstalledLookAndFeels();
   public PlafMenu () {
		super("Plaf");
		ButtonGroup rbGroup = new ButtonGroup();
		JRadioButtonMenuItem rb;
		String lfs = UIManager.getCrossPlatformLookAndFeelClassName();
		String lfName;
		for (int i = 0; i < lfi.length; i++) {
			rb = new JRadioButtonMenuItem(lfi[i].getName());
			rb.addActionListener(this);
			rbGroup.add(rb);
			add(rb);
			lfName = lfi[i].getClassName();
			if (lfs.equals(lfName))
				 rb.setSelected(true);
			else
				try {
					LookAndFeel lf = 
						(LookAndFeel) Class.forName(lfName).newInstance();
					if (!lf.isSupportedLookAndFeel())
						rb.setEnabled(false);
				} 
			catch ( Exception ex ) { 
			   rb.setEnabled(false);
			}
		}
	}
   public void actionPerformed(ActionEvent e) {
		String lfName = null;
		String comm = e.getActionCommand();	
		for (int i = 0; i < lfi.length; i++) 
			if (comm.equals(lfi[i].getName())) {
		  	  lfName = lfi[i].getClassName(); 
			  break;
			}	
		try {
			UIManager.setLookAndFeel(lfName);
			SwingUtilities.updateComponentTreeUI(SwingUtilities.getRoot(this));
		} 
		catch ( Exception ex ) {
			System.err.println( "Could not load " + lfName );
		}
	}
}

