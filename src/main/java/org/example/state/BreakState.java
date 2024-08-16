package org.example.state;

import javax.swing.*;
import java.awt.*;

public class BreakState implements State{
    private Image image = new ImageIcon("img/fun64.png").getImage();
    @Override
    public void doAction() {
        System.out.println("Каникулы!!");
    }

    @Override
    public Image getImage() {
        return image;
    }
}
