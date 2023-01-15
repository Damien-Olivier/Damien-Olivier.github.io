import java.awt.*;
import javax.swing.*;
import java.awt.image.*;

public class ImageSynthese extends JPanel {
    static final int L = 400;
    static final int H = 250;
    Image uneImage;
    ImageSynthese() {
        setPreferredSize(new Dimension(L, H));
        int tabPixels[] = new int[L * H];
        int i = 0;
        for (int y = 0; y < H; y++) {
            for (int x = 0; x < L; x++) {
                int dx = x - L / 2;
                int dy = y - H / 2;
                int r = Math.max(255 - (dx * dx + dy * dy) / 50, 0);
                tabPixels[i++] = (255 << 24) | (r << 16) | (r << 8) | r;
            }
        }
        uneImage = createImage(new MemoryImageSource(L, H, tabPixels, 0, L));
    }
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(uneImage, 0, 0, this);
    }
    
    public static void main(String[] args) {
	JFrame cadre = new JFrame("Afficher une image");
	cadre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	cadre.getContentPane().add(new ImageSynthese());
	cadre.pack();
	cadre.setVisible(true);
    }
}
