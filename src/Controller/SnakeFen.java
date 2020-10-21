package Controller;

import javax.swing.*;
import java.awt.*;

public class SnakeFen extends JFrame {
    SnakeFen fen;
    public SnakeFen()
    {
        StartSnake.dim =Toolkit.getDefaultToolkit().getScreenSize();
        Dimension dim=StartSnake.dim;
        this.setTitle("Snake");
        this.setVisible(true);
        this.setSize(805, 700);
        this.setResizable(false);
        this.setLocation(dim.width / 2 - this.getWidth() / 2, dim.height / 2 - this.getHeight() / 2);
        this.add(StartSnake.snakeDessin=new SnakeDessin());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        StartSnake snakeserpent=new StartSnake();
        snakeserpent.startGame();
        StartSnake.snake=snakeserpent;
        this.addKeyListener(snakeserpent);
    }

}
