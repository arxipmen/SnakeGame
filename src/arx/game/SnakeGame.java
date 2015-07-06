package arx.game;

import arx.game.objects.Snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SnakeGame extends JPanel implements ActionListener{

    public static final int SCALE   = 32;
    public static final int WIDTH   = 30;
    public static final int HEIGHT  = 30;
    public static final int SPEED   = 3;

    Snake snake = new Snake(10, 10, 10, 10);
    Timer timer = new Timer(1000 / SPEED, this);

    public SnakeGame() {
        timer.start();
    }

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
        for(int  tail = 0; tail < snake.lengthSnake; tail++) {
            g.setColor(color(255, 255, 255));
            g.fillRect(snake.snakeX[tail] * SCALE + 1, snake.snakeY[tail] * SCALE + 1, SCALE - 1, SCALE - 1);
        }
    }

    public Color color(int red, int green, int blue) {
        return new Color(red, green, blue);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        snake.move();
        repaint();
    }
}
