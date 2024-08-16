package org.example.facade;

import javax.swing.*;
import java.awt.*;

public class Car {
    private Image carIcon;
    private int x;
    private int y;
    private int speed;

    public Car(int x, int y, int speed){
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.carIcon = new ImageIcon("img/auto.png").getImage();
    }
    public void move(){
        this.x += this.speed;
        if(x>1100){
            this.x = -250;
        }
    }
    public void draw(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(carIcon,x,y,null);
    }
    public int getX() {
        return x;
    }

    public void stop(){
        this.speed = 0;
    }
}
