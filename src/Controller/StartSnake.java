package Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;

public class StartSnake extends SnakeMoveKey implements ActionListener {

    public static StartSnake snake;
    public static SnakeDessin snakeDessin;
    public int ticks = 0, score, tailLength = 10, time;
    public Point bouche, cherry;
    public Random random;
    public ArrayList<Point> nourriture = new ArrayList<Point>();
    public Timer timer = new Timer(50, this);
    public static Dimension dim;

    public boolean positionApparition(int x, int y){
        for (Point point : nourriture) {
            if (point.equals(new Point(x, y))) {
                return false;
            }
        }
        return true;
    }

    public void startGame(){
        over = false;
        paused = false;
        time = 0;
        score = 0;
        tailLength = 0;
        ticks = 0;
        direction = DOWN;
        bouche = new Point(0, -1);
        random = new Random();
        nourriture.clear();
        cherry = new Point(random.nextInt(79), random.nextInt(66));
        timer.start();
    }
    @Override
    public void keyPressed(KeyEvent e){
        int i = e.getKeyCode();
        if((i == KeyEvent.VK_A || i == KeyEvent.VK_LEFT) && direction != RIGHT) {
            direction = LEFT;
        }
        if((i == KeyEvent.VK_D || i == KeyEvent.VK_RIGHT) && direction != LEFT) {
            direction = RIGHT;
        }
        if((i == KeyEvent.VK_W || i == KeyEvent.VK_UP) && direction != DOWN) {
            direction = UP;
        }
        if((i == KeyEvent.VK_S || i == KeyEvent.VK_DOWN) && direction != UP) {
            direction = DOWN;
        }
        if(i == KeyEvent.VK_SPACE){
            if(over){
                startGame();
            }else{
                paused = !paused;
            }
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        snakeDessin.repaint();
        ticks++;

        if (ticks % 2 == 0 && bouche != null && !over && !paused) {
            time++;
            nourriture.add(new Point(bouche.x, bouche.y));
            if (direction == UP) {
                if(bouche.y - 1 >= 0 && positionApparition(bouche.x, bouche.y - 1)) {
                    bouche = new Point(bouche.x, bouche.y - 1);
                }else {
                    over = true;
                }
            }
            if (direction == DOWN) {
                if (bouche.y + 1 < 67 && positionApparition(bouche.x, bouche.y + 1)) {
                    bouche = new Point(bouche.x, bouche.y + 1);
                }else{
                    over = true;
                }
            }
            if (direction == LEFT) {
                if (bouche.x - 1 >= 0 && positionApparition(bouche.x - 1, bouche.y)) {
                    bouche = new Point(bouche.x - 1, bouche.y);
                }else{
                    over = true;
                }
            }
            if (direction == RIGHT) {
                if (bouche.x + 1 < 80 && positionApparition(bouche.x + 1, bouche.y)) {
                    bouche = new Point(bouche.x + 1, bouche.y);
                }else{
                    over = true;
                }
            }
            if (nourriture.size() > tailLength) {
                nourriture.remove(0);
            }
            if (cherry != null) {
                if (bouche.equals(cherry)) {
                    score += 10;
                    tailLength++;
                    cherry.setLocation(random.nextInt(79), random.nextInt(66));
                }
            }
        }
    }
}
