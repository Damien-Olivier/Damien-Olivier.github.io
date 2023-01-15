/*Copyright (c) 1995, 1996 Sun Microsystems, Inc. All Rights Reserved. */
import java.awt.*;

public class GridWindow extends Frame {
    private boolean inAnApplet = true;

    public GridWindow() {
        setLayout(new GridLayout(0,2));
        setFont(new Font("Helvetica", Font.PLAIN, 14));
   
        add(new Button("Button 1"));
        add(new Button("2"));
        add(new Button("Button 3"));
        add(new Button("Long-Named Button 4"));
        add(new Button("Button 5"));
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
        GridWindow window = new GridWindow();
        window.inAnApplet = false;

        window.setTitle("GridWindow Application");
        window.pack();
        window.show();
    }
}
