package org.example.state;

import javax.swing.*;
import java.awt.*;

public class SessionState implements State{
    private Image image = new ImageIcon("img/sed64.png").getImage();
    @Override
    public void doAction() {
        System.out.println("Сессия");
    }

    @Override
    public Image getImage() {
        return image;
    }
}
