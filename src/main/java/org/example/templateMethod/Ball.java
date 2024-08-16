package org.example.templateMethod;

import javax.swing.*;
import java.awt.*;

public class Ball extends Template{
    private int x;
    private int y;
    private int dx;
    private int dy;

    public Ball(int x,int y, int dx, int dy){
        this.x = x;
        this.y = y;
        this.dx = dx;
        this.dy = dy;
    }
    @Override
    void draw(Graphics g, int x, int y) {
        g.setColor(Color.RED);
        g.fillOval(x, y, 40, 40);
    }

    @Override
    void move() {
        x += dx;
        y += dy;

        if (x <= 0 || x >= 300 - 40) {
            dx = -dx;
        }

        if (y <= 0 || y >= 200 - 40) {
            dy = -dy;
        }
    }



    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}