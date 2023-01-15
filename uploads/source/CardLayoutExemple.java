import java.applet.Applet;
	import java.awt.*;
	import java.awt.event.*;

	public class CardLayoutExemple extends Applet 
	 implements ActionListener {
	 CardLayout carte;
	 Panel fruitEtLegume;
	 Button bouton=new Button("Fruits ou Légumes");

	 public void init() {
	  //panel de la première carte (les fruits)
	  Panel p1 = new Panel();
	  p1.add(new Button("Pomme"));
	  p1.add(new Button("Poire"));
	  p1.add(new Button("Abricot"));
	  p1.setBackground(Color.orange);
	  //panel de la deuxieme carte (les legumes)
	  Panel p2 = new Panel(); 
	  p2.add(new Button("Tomate"));
	  p2.add(new Button("Poireau"));
	  p2.add(new Button("Haricot"));
	  p2.setBackground(Color.green);
	  //panel contenant les deux précédents
	  fruitEtLegume=new Panel();
	  carte = new CardLayout();
	  fruitEtLegume.setLayout(carte);
	  fruitEtLegume.add("fruit", p1);
	  fruitEtLegume.add("legume", p2);
	  setLayout(new BorderLayout());
	  add("North", bouton);
	  add("Center", fruitEtLegume);
	  bouton.addActionListener(this);
	 }

	 public void actionPerformed(ActionEvent e) {
	  carte.next(fruitEtLegume);
	 }
	}
