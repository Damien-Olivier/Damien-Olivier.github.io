
// MVC Applet
import java.awt.*;
import java.applet.Applet;
import java.awt.event.*;
import javax.swing.*;

class Compteur {
    private int valeur = 0;
    CompteurView myView;

    Compteur(CompteurView aView){
        myView = aView;
    }

    public void bump() {
        valeur++;
        myView.repaint();
    }
    public void raz() {
        valeur=0;
        myView.repaint();
    }

    public void display(Graphics g) {
        g.drawString("Valeur="+valeur,20,50);
    }
}   

public class CompteurView extends JApplet{
    // instance variables etc
    private Compteur aModel;
    private CompteurController aController;
    private Button bumpButton,razButton;

    public void init(){
        bumpButton = new Button("++");
        add(bumpButton);
        razButton = new Button("RAZ");
        add(razButton);

        aModel = new Compteur(this);
        aController = new CompteurController(aModel,bumpButton,razButton);
    }

    public void paint(Graphics g) {
        aModel.display(g);
    }
    
}


class CompteurController implements ActionListener{
    Compteur model;
    CompteurView view;
    private Button bumpButton,razButton;
        
    CompteurController(Compteur model,
                       Button bumpButton,Button razButton){
        this.bumpButton = bumpButton;
        this.razButton = razButton;
        bumpButton.addActionListener(this);
        razButton.addActionListener(this);

        this.model = model;
    }
        
    public void actionPerformed(ActionEvent event) {
        String actionCommand = ((Button)event.getSource()).getActionCommand();
        if(actionCommand.equals(bumpButton.getActionCommand()))
            model.bump();
        if(actionCommand.equals(razButton.getActionCommand()))
            model.raz();
    }
}
