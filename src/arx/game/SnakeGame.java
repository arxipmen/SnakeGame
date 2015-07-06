package arx.game;

import javax.swing.*;
import java.awt.*;

public class SnakeGame extends JPanel{

    public static final int SCALE   = 32;
    public static final int WIDTH   = 20;
    public static final int HEIGHT  = 20;

    public static void main(String ... Args) {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setResizable(false);
        f.setSize(WIDTH * SCALE + 5, HEIGHT * SCALE - 12);
        f.setLocationRelativeTo(null);
        f.add(new SnakeGame());
        f.setVisible(true);
    }

    public void paint(Graphics g) {
        g.setColor(color(10, 80, 50));
        g.fillRect(0, 0, WIDTH * SCALE, HEIGHT * SCALE);
        g.setColor(color(255, 200, 0));
        for(int x = 0; x <= WIDTH * SCALE; x += SCALE) {
            g.drawLine(x, 0, x, HEIGHT * SCALE);
        }
        for(int y = 0; y < HEIGHT * SCALE; y += SCALE) {
            g.drawLine(0, y, WIDTH * SCALE, y);
        }
    }

    public Color color(int red, int green, int blue) {
        return new Color(red, green, blue);
    }
}
