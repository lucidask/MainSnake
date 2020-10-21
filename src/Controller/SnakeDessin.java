package Controller;

import javax.swing.*;
import java.awt.*;

public class SnakeDessin extends JPanel {
    public static final Color GREEN = new Color(1666073);

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        StartSnake snake = StartSnake.snake;

        g.setColor(Color.black);

        g.fillRect(0, 0, 800, 700);

        g.setColor(Color.BLUE);

        for (Point point : snake.nourriture) {
            g.fillOval(point.x * SnakeMoveKey.SCALE, point.y * StartSnake.SCALE, StartSnake.SCALE, StartSnake.SCALE);
        }

        g.fillOval(snake.bouche.x * StartSnake.SCALE, snake.bouche.y * StartSnake.SCALE, StartSnake.SCALE, StartSnake.SCALE);

        g.setColor(Color.RED);

        g.fillOval(snake.cherry.x * StartSnake.SCALE, snake.cherry.y * StartSnake.SCALE, StartSnake.SCALE, StartSnake.SCALE);

        String string = "Score: " + snake.score + ", Longueur: " + snake.tailLength + ", Temps: " + snake.time / 20;

        g.setColor(Color.white);

        g.drawString(string, (int) (getWidth() / 2 - string.length() * 2.5f), 10);

        string = "Game Over!";

        if (snake.over) {
            g.drawString(string, (int) (getWidth() / 2 - string.length() * 2.5f), (int) snake.dim.getHeight() / 4);
        }

        string = "Pause!";

        if (snake.paused && !snake.over) {
            g.drawString(string, (int) (getWidth() / 2 - string.length() * 2.5f), (int) snake.dim.getHeight() / 4);
        }
    }
}

