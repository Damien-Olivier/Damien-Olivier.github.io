/* Copyright (c) 1995, 1996 Sun Microsystems, Inc. All Rights Reserved. */
import java.awt.*;

public class BorderWindow extends Frame {
    private boolean inAnApplet = true;
     
    public BorderWindow() {
        setLayout(new BorderLayout());
        setFont(new Font("Helvetica", Font.PLAIN, 14));
   
        add("North", new Button("North"));
        add("South", new Button("South"));
        add("East", new Button("East"));
        add("West", new Button("West"));
        add("Center", new Button("Center"));
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
        BorderWindow window = new BorderWindow();
        window.inAnApplet = false;

        window.setTitle("BorderWindow Application");
        window.pack();
        window.show();
    }
}
