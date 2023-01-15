import java.awt.Graphics;

public class VieDuneApplet extends java.applet.Applet {

    StringBuffer buffer = new StringBuffer();

    public void init() {
	resize(500, 20);
        addItem("initialisation... ");
    }

    public void start() {
        addItem("démarrage... ");
    }

    public void stop() {
        addItem("arrêt... ");
    }

    public void destroy() {
	addItem("adieu Monde Cruel ...");
    }

    public void addItem(String newWord) {
	System.out.println(newWord);
	buffer.append(newWord);
	repaint();
    }

    public void paint(Graphics g) {
	g.drawRect(0, 0, getSize().width - 1, getSize().height - 1);
	g.drawString(buffer.toString(), 5, 15);
    }
}
