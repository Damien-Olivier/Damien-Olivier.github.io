/* Copyright (c) 1995, 1996 Sun Microsystems, Inc. All Rights Reserved. */
import java.awt.*;

public class CardWindow extends Frame {
    private boolean inAnApplet = true;
     
    Panel cards;
    final static String BUTTONPANEL = "Panel with Buttons";
    final static String TEXTPANEL = "Panel with TextField";

    public CardWindow() {
        setLayout(new BorderLayout());
        setFont(new Font("Helvetica", Font.PLAIN, 14));

        //Put the Choice in a Panel to get a nicer look.
        Panel cp = new Panel();
        Choice c = new Choice();
        c.addItem(BUTTONPANEL);
        c.addItem(TEXTPANEL);
        cp.add(c);
        add("North", cp);

        cards = new Panel();
        cards.setLayout(new CardLayout());
   
        Panel p1 = new Panel();
        p1.add(new Button("Button 1"));
        p1.add(new Button("Button 2"));
        p1.add(new Button("Button 3"));

        Panel p2 = new Panel();
        p2.add(new TextField("TextField", 20));

        cards.add(BUTTONPANEL, p1);
        cards.add(TEXTPANEL, p2);
        add("Center", cards);
    }

    public boolean action(Event evt, Object arg) {
        if (evt.target instanceof Choice) {
            ((CardLayout)cards.getLayout()).show(cards,(String)arg);
            return true;
        }
        return false;
    }

    public boolean handleEvent(Event e) {
        if (e.id == Event.WINDOW_DESTROY) {
            if (inAnApplet) {
                dispose();
                return true;
            } else {
                System.exit(0);
            }
        }   
        return super.handleEvent(e);
    }

    public static void main(String args[]) {
        CardWindow window = new CardWindow();
        window.inAnApplet = false;

        window.setTitle("CardWindow Application");
        window.pack();
        window.show();
    }
}
