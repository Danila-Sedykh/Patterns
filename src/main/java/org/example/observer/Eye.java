package org.example.observer;

import javax.swing.*;
import java.awt.*;

public class Eye implements Observer{
    private boolean isOpen = true;
    private Image imageEye = new ImageIcon("img/EyeOpen.png").getImage();
    @Override
    public void update() {
        isOpen = !isOpen;
        if (!isOpen){
            imageEye = new ImageIcon("img/EyeClose.png").getImage();
        }else {
            imageEye = new ImageIcon("img/EyeOpen.png").getImage();
        }
    }
    public Image getImageEye(){
        return imageEye;
    }
}
