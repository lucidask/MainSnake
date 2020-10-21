package Controller;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class SnakeMoveKey extends KeyAdapter {
    public static final int UP = 0, DOWN = 1, LEFT = 2, RIGHT = 3, SCALE = 10;
    public static int direction= RIGHT;
    public boolean over = false, paused;
}
