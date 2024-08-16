package org.example.templateMethod;

import javax.swing.*;
import java.awt.*;

abstract class Template {

    abstract void draw(Graphics g, int x, int y);

    abstract void move();

    public void animate(JPanel panel) {
        new Thread(() -> {
            while (true) {
                move();
                panel.repaint();

                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
