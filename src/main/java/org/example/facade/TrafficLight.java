package org.example.facade;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TrafficLight {
    private int xRed, yRed;
    private int xYellow, yYellow;
    private int xGreen, yGreen;
    private Color currentColor;
    private int interval;
    private Timer timer;

    public TrafficLight(int xRed, int yRed, int xYellow, int yYellow, int xGreen, int yGreen, int interval) {
        this.xRed = xRed;
        this.yRed = yRed;
        this.xYellow = xYellow;
        this.yYellow = yYellow;
        this.xGreen = xGreen;
        this.yGreen = yGreen;
        this.currentColor = Color.RED;
        this.interval = interval;

        timer = new Timer(interval, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchColor();
            }
        });
        timer.start();


    }
    public void switchColor() {
        if (currentColor == Color.RED) {
            currentColor = Color.YELLOW;
        } else if (currentColor == Color.YELLOW) {
            currentColor = Color.GREEN;
        } else {
            currentColor = Color.RED;
        }

    }

    public void draw(Graphics g) {
        g.setColor(currentColor);
        if (currentColor == Color.RED) {
            g.fillOval(xRed, yRed, 30, 30);
        } else if (currentColor == Color.YELLOW) {
            g.fillOval(xYellow, yYellow, 30, 30);
        } else {
            g.fillOval(xGreen, yGreen, 30, 30);
        }
    }
    public Color getColor() {
        return currentColor;
    }

    public int getxRed() {
        return xRed;
    }


}
