package org.example.state;

import javax.swing.*;
import java.awt.*;

public class SemesterState implements State{
    private Image image = new ImageIcon("img/sleep96.png").getImage();
    @Override
    public void doAction() {
        System.out.println("Семестр");
    }

    @Override
    public Image getImage() {
        return image;
    }
}
