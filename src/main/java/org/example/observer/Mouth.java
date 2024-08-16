package org.example.observer;

import javax.swing.*;
import java.awt.*;

public class Mouth implements Observer {
    private boolean isSmiling = false;
    private Image imageSmiling = new ImageIcon("img/MouthOpen.png").getImage();

    @Override
    public void update() {
        isSmiling = !isSmiling;
        if (isSmiling) {
            imageSmiling = new ImageIcon("img/MouthClose.png").getImage();
        } else {
            imageSmiling = new ImageIcon("img/MouthOpen.png").getImage();
        }
        System.out.println("Mouth is " + (isSmiling ? "smiling" : "not smiling"));
    }

    public void draw(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(imageSmiling,73 , 170,null);
    }
}
