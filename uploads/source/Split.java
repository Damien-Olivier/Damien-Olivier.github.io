import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Split extends JFrame {
    protected PanneauBoules aireGauche;
    protected PanneauBoules aireDroite;

    public Split() {
	super("Des boules");
	setSize(600, 400);
	//addWindowListener(new Fermeur());
	getContentPane().setLayout(new BorderLayout());
		
	ImageIcon bleue = new ImageIcon("bleue.gif");
	aireGauche = new PanneauBoules(150, bleue.getImage());
	ImageIcon rouge = new ImageIcon("rouge.gif");
	aireDroite = new PanneauBoules(150, rouge.getImage());
	JSplitPane sp = new JSplitPane(
	  JSplitPane.HORIZONTAL_SPLIT, aireGauche, aireDroite);
	sp.setDividerSize(5);
	sp.setContinuousLayout(true);
	getContentPane().add(sp, BorderLayout.CENTER);

	JMenuBar mb = new JMenuBar();
	getRootPane().setJMenuBar(mb);
	JMenu menu = new JMenu("Threads");
	mb.add(menu);
	menu.add(new MenuAction(10));
	menu.add(new MenuAction(20));
	menu.add(new MenuAction(30));
	menu.add(new MenuAction(50));
	menu.add(new MenuAction(100));
	menu.add(new MenuAction(0));

	setVisible(true);

	new Thread(aireGauche).start();
	new Thread(aireDroite).start();
    }

    public static void main(String argv[]) {
	new Split();
    }


class MenuAction extends AbstractAction {
    int vitesse;
    public MenuAction(int vitesse) {
	super(Integer.toString(vitesse));
	this.vitesse = vitesse;
    }
    public void actionPerformed(ActionEvent e) {
	aireGauche.sommeil = vitesse;
	aireDroite.sommeil = vitesse;
    }
}
}
class PanneauBoules extends JPanel 
    implements Runnable, ComponentListener
{
    protected Boule[] boules;
    protected Image img;
    protected Dimension dim;
    protected int sommeil;
    public PanneauBoules(int nBoules, Image img) {
	sommeil = 10;
	this.img = img;
	setBackground(Color.yellow);
	setPreferredSize(new Dimension(200,300));
	addComponentListener(this);
	boules = new Boule[nBoules];
	dim = getPreferredSize();
	for (int k=0; k<nBoules; k++)
	    boules[k] = new Boule(dim);
    }
    public void run() {
	for(;;) {
	    for (int k = 0; k < boules.length; k++)
		boules[k].move(dim);
	    repaint();
	    if (sommeil != 0) {	
  	    try { 
 		Thread.sleep(sommeil); 
 	    } 
 	    catch(InterruptedException e) {}}
	}
    }

    public void paintComponent(Graphics g) {
	g.setColor(getBackground());
	g.fillRect(0,0, dim.width, dim.height);

	for (int k=0; k<boules.length; k++)
	    g.drawImage(img, (int)boules[k].x, (int)boules[k].y, this);
    }

    public void componentHidden(ComponentEvent e){}
    public void componentShown(ComponentEvent e){}
    public void componentMoved(ComponentEvent e){}
    public void componentResized(ComponentEvent e){
	dim = getSize();
	for (int k = 0; k < boules.length; k++)
	    boules[k].moveIntoRect(dim);
    }
}

class Boule {
    protected double x, y, vx, vy;
    public Boule(Dimension dim) {
	x = dim.width*Math.random();
	y = dim.height*Math.random();
	double angle = 2*Math.PI*Math.random();
	vx = 2*Math.cos(angle);
	vy = 2*Math.sin(angle);
    }

    public void move(Dimension dim) {
	double nx = x + vx;
	double ny = y + vy;
	if ((nx < 0)|| (nx > dim.width)) {
	    vx = - vx;
	    nx = x + vx;
	}
	if ((ny < 0)||(ny > dim.height)) {
	    vy = - vy;
	    ny = y + vy;
	}
	x = nx;
	y = ny;
    }

    public void moveIntoRect(Dimension dim) {
	x = Math.max(x, 0);
	x = Math.min(x, dim.width);
	y = Math.max(y, 0);
	y = Math.min(y, dim.height);
    }
}

