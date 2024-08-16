package org.example.observer;

import java.awt.*;

public class Nose implements Observer{
    private Color color = Color.BLACK;
    @Override
    public void update() {
        color = color == Color.BLACK ? Color.RED : Color.BLACK;
        System.out.println("Nose color changed to " + color);

    }
    public Color getColor() {
        return color;
    }
}
